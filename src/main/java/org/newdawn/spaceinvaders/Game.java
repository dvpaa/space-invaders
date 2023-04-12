package org.newdawn.spaceinvaders;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.swing.*;

import org.newdawn.spaceinvaders.entity.AlienEntity;
import org.newdawn.spaceinvaders.entity.Entity;
import org.newdawn.spaceinvaders.entity.ShipEntity;
import org.newdawn.spaceinvaders.entity.item.AttackItemEntity;
import org.newdawn.spaceinvaders.entity.item.ItemEntity;
import org.newdawn.spaceinvaders.entity.item.SpeedItem;

/**
 * The main hook of our game. This class with both act as a manager
 * for the display and central mediator for the game logic.
 *
 * Display management will consist of a loop that cycles round all
 * entities in the game asking them to move and then drawing them
 * in the appropriate place. With the help of an inner class it
 * will also allow the player to control the main ship.
 *
 * As a mediator it will be informed when entities within our game
 * detect events (e.g. alient killed, played died) and will take
 * appropriate game actions.
 *
 * @author Kevin Glass
 */
public class Game extends Canvas
{
	/** The stragey that allows us to use accelerate page flipping */
	private BufferStrategy strategy;
	/** True if the game is currently "running", i.e. the game loop is looping */
	private boolean gameRunning = true;
	/** The list of all the entities that exist in our game */
	private ArrayList<Entity> entities = new ArrayList<>();
	/** The list of entities that need to be removed from the game this loop */
	private ArrayList removeList = new ArrayList();
	/** The entity representing the player */
	private Entity ship;
	/** The speed at which the player's ship should move (pixels/sec) */
	private double moveSpeed = 300;
	/** The time at which last fired a shot */
	private long lastShipFire = 0;

	private long lastShipSkill1 = 0;

	private long lastShipSkill2 = 0;

	private long lastAlienFire = 0;
	/** The interval between our players shot (ms) */
	private long firingInterval = 500;

	private long skillInterval1 = 2000;

	private long skillInterval2 = 2000;

	private long itemInterval = 1000; // 아이템 생성 텀



	/** The number of aliens left on the screen */
	private int alienCount;
	/** The message to display which waiting for a key press */
	private String message = "";
	/** True if we're holding up game play until a key has been pressed */
	private boolean waitingForKeyPress = true;
	/** True if the left cursor key is currently pressed */
	private boolean leftPressed = false;
	/** True if the right cursor key is currently pressed */
	private boolean rightPressed = false;
	/** True if we are firing */
	private boolean firePressed = false;

	private boolean skilPressed1 = false;

	private boolean skilPressed2 = false;

	/** True if game logic needs to be applied this loop, normally as a result of a game event */
	private boolean logicRequiredThisLoop = false;
	/** The last time at which we recorded the frame rate */
	private long lastFpsTime;
	/** The current number of frames recorded */
	private int fps;
	/** The normal title of the game window */
	private String windowTitle = "Space Invaders 102";
	/** The game window that we'll update with the frame count */
	private JFrame container;

	private GameTimer gameTimer = new GameTimer(); // add GameTimer by Eungyu
	private JFrame mainPage;
	private JFrame selectStagePage;

	// attribute added by Eungyu
	private long lastItemGenerate = 0;
	private ArrayList itemList = new ArrayList();

	/**
	 * Construct our game and set it running.
	 */
	public Game() {
		/** 원본 container ~~ **/
		// create a frame to contain our game
		container = new JFrame("Space Invaders 102");

		// get hold the content of the frame and set up the resolution of the game
		// 게임 프레임 & 해상도 설정
		JPanel panel = (JPanel) container.getContentPane();
		panel.setPreferredSize(new Dimension(800,600));
		panel.setLayout(null);

		JLabel timerlabel = gameTimer.getTimerLabel(); // 타이머 라벨 추가 add GameTimer by Eungyu
		timerlabel.setBounds(740,0, 60, 25); // 타이머 크기, 위치 지정 add GameTimer by Eungyu
		timerlabel.setOpaque(true); // 라벨 배경 색깔 적용 add GameTimer by Eungyu
		timerlabel.setBackground(Color.black); // 뒷배경 검은색 설정 add GameTimer by Eungyu
		timerlabel.setForeground(Color.white); // 글씨 하얀색 설정 add GameTimer by Eungyu
		panel.add(timerlabel); // 패널에 타이머 라벨 추가 add GameTimer by Eungyu

		// setup our canvas size and put it into the content of the frame
		setBounds(0,0,800,600);
		panel.add(this);

		// Tell AWT not to bother repainting our canvas since we're
		// going to do that our self in accelerated mode
		setIgnoreRepaint(true);

		// finally make the window visible
		container.pack();
		container.setResizable(false);
		container.setVisible(true);

		// add a listener to respond to the user closing the window. If they
		// do we'd like to exit the game
		container.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/** ~~ 원본 container **/

		// add a key input system (defined below) to our canvas
		// so we can respond to key pressed
		addKeyListener(new KeyInputHandler());

		// request the focus so key events come to us
		requestFocus();

		// create the buffering strategy which will allow AWT
		// to manage our accelerated graphics
		createBufferStrategy(2);
		strategy = getBufferStrategy();

		// initialise the entities in our game so there's something
		// to see at startup
		initEntities();
	}

	public void mainPage(){
		// 게임 실행 하자마자 나오는 메인 페이지
		mainPage = new JFrame("Space Invaders Main Page");
		// frame 크기 800x600으로 설정
		mainPage.setPreferredSize(new Dimension(800, 600));

		// content pane 가져오기
		Container mainPageContainPane = mainPage.getContentPane();

		// 화면에 게임 이름 이미지로 넣기(수정)
		JLabel showGameName = new JLabel("Space Invaders");
		showGameName.setBounds(100, 100, 100, 20);
		mainPage.add(showGameName);

		// 버튼 생성 & 위치 설정
		JButton gameStartButton = new JButton("GameStart");
		gameStartButton.setBounds(100, 300, 600, 60);
		JButton goStoreButton = new JButton("Store");
		goStoreButton.setBounds(100, 380, 600, 60);
		JButton goRankingButton = new JButton("Ranking");
		goRankingButton.setBounds(100, 460, 600, 60);

		// 버튼 눌렀을 때 페이지 이동
		gameStartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectStagePage();
				mainPage.setVisible(false); // 창 안보이게 하기
			}
		});

		// 화면에 버튼 보이도록 contain pane에 버튼 붙이기
		mainPageContainPane.add(gameStartButton);
		mainPageContainPane.add(goStoreButton);
		mainPageContainPane.add(goRankingButton);

		//panel의 레이아웃 매니저를 null로 설정 : 컴포넌트들의 위치와 크기를 수동으로 설정 가능 하도록
		// setLayout(null)으로 설정하면 각 구성 요소의 위치와 크기를 직접 지정해야 함
		mainPage.setLayout(null);
		mainPage.pack();
		mainPage.setVisible(true);

		mainPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void selectStagePage(){
		// stage 선택 페이지
		selectStagePage = new JFrame("SelectStagePage"); // frame 생성

		// frame 크기 800x600으로 설정
		selectStagePage.setPreferredSize(new Dimension(800,600));

		// content pane 가져오기
		Container selectStageContainPane = selectStagePage.getContentPane();

		// 어떤 페이지인지 알 수 있도록 "STAGE"써있는 이미지 넣기
		JLabel stageShowGameName = new JLabel("STAGE");
		stageShowGameName.setBounds(0, 0, 800, 100); // x, y, width, height
		selectStagePage.add(stageShowGameName);

		// 버튼 생성 & 위치 설정
		JButton[] stageButton = new JButton[5];
		for(int i=0;i<5;i++){
			stageButton[i] = new JButton("STAGE " + (i+1));
			int y = 130 + 70*i;
			stageButton[i].setBounds(100, y, 500, 60);
		}

		for(int i=0; i<5 ; i++){
			selectStageContainPane.add(stageButton[i]);
		}

		stageButton[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Game();
				selectStagePage.setVisible(false); // 창 안보이게 하기
			}
		});

		selectStagePage.setLayout(null);
		selectStagePage.pack();
		selectStagePage.setVisible(true);

		selectStagePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ~~ stage 선택 페이지
	}

	/**
	 * Start a fresh game, this should clear out any old data and
	 * create a new set.
	 */
	private void startGame() {
		// clear out any existing entities and intialise a new set
		entities.clear();
		initEntities();
		// blank out any keyboard settings we might currently have
		leftPressed = false;
		rightPressed = false;
		firePressed = false;
    	skilPressed1 = false;
		skilPressed2 = false;

		gameTimer.startTimer(); // 게임시작시 타이머 시작 add GameTimer by Eungyu
		
	}

	/**
	 * Initialise the starting state of the entities (ship and aliens). Each
	 * entitiy will be added to the overall list of entities in the game.
	 */
	private void initEntities() {
		// create the player ship and place it roughly in the center of the screen
		ship = new ShipEntity(this, "sprites/ship.gif",370,550, 1);
		entities.add(ship);

		// create a block of aliens (5 rows, by 12 aliens, spaced evenly)
		alienCount = 0;
		for (int row=0;row<5;row++) {
			for (int x=0;x<12;x++) {
				Entity alien = new AlienEntity(this,100+(x*50),(50)+row*30);
				entities.add(alien);
				alienCount++;
			}
		}
	}

	/**
	 * Notification from a game entity that the logic of the game
	 * should be run at the next opportunity (normally as a result of some
	 * game event)
	 */
	public void updateLogic() {
		logicRequiredThisLoop = true;
	}

	/**
	 * Remove an entity from the game. The entity removed will
	 * no longer move or be drawn.
	 *
	 * @param entity The entity that should be removed
	 */
	public void removeEntity(Entity entity) {
		removeList.add(entity);
	}

	/**
	 * Notification that the player has died.
	 */
	public void notifyDeath() {
		gameTimer.stopTimer(); // 게임 종료시 타이머 종료 add GameTimer by Eungyu
		// 종료시 message를 시간이랑 같이 초기화 add GameTimer by Eungyu
		message = "Oh no! They got you, try again? \nYour time is " + gameTimer.getEndTime();
		waitingForKeyPress = true;

		// 게임 종료시 아이템 효과 초기화 및 아이템 제거
		for(int i=0; i<itemList.size(); i++){
			((ItemEntity)itemList.get(i)).resetItemEffect();
		}
		itemList.clear();
	}

	/**
	 * Notification that the player has won since all the aliens
	 * are dead.
	 */
	public void notifyWin() {
		gameTimer.stopTimer();
		// 종료시 message를 시간이랑 같이 초기화 add GameTimer by Eungyu
		message = "Well done! You Win! \nYour time is " + gameTimer.getEndTime();
		waitingForKeyPress = true;
		for(int i=0; i<itemList.size(); i++){
			((ItemEntity)itemList.get(i)).resetItemEffect();
		}
		itemList.clear();
	}

	/**
	 * Notification that an alien has been killed
	 */
	public void notifyAlienKilled() {
		// reduce the alient count, if there are none left, the player has won!
		alienCount--;

		if (alienCount == 0) {
			notifyWin();
		}

		// if there are still some aliens left then they all need to get faster, so
		// speed up all the existing aliens
		for (int i=0;i<entities.size();i++) {
			Entity entity = (Entity) entities.get(i);

			if (entity instanceof AlienEntity) {
				// speed up by 2%
				entity.setHorizontalMovement(entity.getHorizontalMovement() * 1.02);
			}
		}
	}

	/**
	 * Attempt to fire a shot from the player. Its called "try"
	 * since we must first check that the player can fire at this
	 * point, i.e. has he/she waited long enough between shots
	 */
	public void tryToFire(Entity ship) {
		// check that we have waiting long enough to fire
		if (System.currentTimeMillis() - lastShipFire < firingInterval) {
			return;
		}

		// if we waited long enough, create the shot entity, and record the time.
		lastShipFire = System.currentTimeMillis();
		Entity shot = ship.fire();
		entities.add(shot);
	}

	public void tryToSkill1(Entity ship) {
		// check that we have waiting long enough to fire
		if (System.currentTimeMillis() - lastShipSkill1 < skillInterval1) {
			return;
		}

		// if we waited long enough, create the shot entity, and record the time.
		lastShipSkill1 = System.currentTimeMillis();
		Entity shot = ship.skill1();
		entities.add(shot);
	}

	public void tryToSkill2(Entity ship) {
		// check that we have waiting long enough to fire
		if (System.currentTimeMillis() - lastShipSkill2 < skillInterval2) {
			return;
		}

		// if we waited long enough, create the shot entity, and record the time.
		lastShipSkill2 = System.currentTimeMillis();
		Entity shot = ship.skill2();
		entities.add(shot);
	}

	public void attackFromAlien(Entity alien) {
		if (System.currentTimeMillis() - lastAlienFire < firingInterval) {
			return;
		}
		lastAlienFire = System.currentTimeMillis();
		Entity shot = alien.fire();
		entities.add(shot);
	}

	public Entity selectAttackAlien(ArrayList<Entity> entities) {
		List<Entity> list = entities.stream()
				.filter(entity -> entity instanceof AlienEntity)
				.sorted(Comparator.comparing(Entity::getY).reversed())
				.limit(12)
				.collect(Collectors.toList());

		int standardY = list.get(0).getY();
		int idx = 11;
		for (int i = 1; i < list.size(); i++) {
			if (standardY != list.get(i).getY()) {
				idx = i - 1;
				break;
			}
		}
		int max = idx;
		int min = 0;
		int randomInt = (int) (Math.random() * (max - min + 1) + min);
		return list.get(randomInt);
	}

	/**
	 * The main game loop. This loop is running during all game
	 * play as is responsible for the following activities:
	 * <p>
	 * - Working out the speed of the game loop to update moves
	 * - Moving the game entities
	 * - Drawing the screen contents (entities, text)
	 * - Updating game events
	 * - Checking Input
	 * <p>
	 */
	// method added by Enugyu


	public void gameLoop() {
		long lastLoopTime = SystemTimer.getTime();

		// keep looping round til the game ends
		while (gameRunning) {
			// work out how long its been since the last update, this
			// will be used to calculate how far the entities should
			// move this loop
			long delta = SystemTimer.getTime() - lastLoopTime;
			lastLoopTime = SystemTimer.getTime();

			// update the frame counter
			lastFpsTime += delta;
			fps++;

			// update our FPS counter if a second has passed since
			// we last recorded
			if (lastFpsTime >= 1000) {
				container.setTitle(windowTitle+" (FPS: "+fps+")");
				lastFpsTime = 0;
				fps = 0;
			}

//			 아이템 생성
			if(System.currentTimeMillis() - lastItemGenerate > itemInterval) {
				Random random = new Random();
				lastItemGenerate = System.currentTimeMillis();
				Entity item = new SpeedItem(this,random.nextInt(600), -35);
				entities.add(item);
			}


			// Get hold of a graphics context for the accelerated 
			// surface and blank it out
			Graphics2D g = (Graphics2D) strategy.getDrawGraphics();
			g.setColor(Color.black);
			g.fillRect(0,0,800,600);

			// cycle round asking each entity to move itself
			if (!waitingForKeyPress) {
				for (int i=0;i<entities.size();i++) {
					Entity entity = (Entity) entities.get(i);

					entity.move(delta);
				}
			}

			// cycle round drawing all the entities we have in the game
			for (int i=0;i<entities.size();i++) {
				Entity entity = (Entity) entities.get(i);

				entity.draw(g);
			}

			// brute force collisions, compare every entity against
			// every other entity. If any of them collide notify 
			// both entities that the collision has occured
			for (int p=0;p<entities.size();p++) {
				for (int s=p+1;s<entities.size();s++) {
					Entity me = (Entity) entities.get(p);
					Entity him = (Entity) entities.get(s);

					if (me.collidesWith(him)) {
						me.collidedWith(him);
						him.collidedWith(me);
					}
				}
			}

			// remove any entity that has been marked for clear up
			entities.removeAll(removeList);
			removeList.clear();

			// if a game event has indicated that game logic should
			// be resolved, cycle round every entity requesting that
			// their personal logic should be considered.

			for(int i=0;i<itemList.size();i++){
				Entity item = (Entity) itemList.get(i);
				((ItemEntity) item).doItemLogic();
			}


			if (logicRequiredThisLoop) {
				for (int i=0;i<entities.size();i++) {
					Entity entity = (Entity) entities.get(i);
					if(entity instanceof ItemEntity){
						((ItemEntity) entity).doItemLogic();
					}
					entity.doLogic();
				}

				logicRequiredThisLoop = false;
			}

			// if we're waiting for an "any key" press then draw the 
			// current message 
			if (waitingForKeyPress) {
				g.setColor(Color.white);
				g.drawString(message,(800-g.getFontMetrics().stringWidth(message))/2,250);
				g.drawString("Press any key",(800-g.getFontMetrics().stringWidth("Press any key"))/2,300);
			}

			// finally, we've completed drawing so clear up the graphics
			// and flip the buffer over
			g.dispose();
			strategy.show();

			// resolve the movement of the ship. First assume the ship 
			// isn't moving. If either cursor key is pressed then
			// update the movement appropraitely
			ship.setHorizontalMovement(0);

			if ((leftPressed) && (!rightPressed)) {
				ship.setHorizontalMovement(-moveSpeed);
			} else if ((rightPressed) && (!leftPressed)) {
				ship.setHorizontalMovement(moveSpeed);
			}

			// if we're pressing fire, attempt to fire
			if (firePressed) {
				tryToFire(ship);
			}

			if (skilPressed1) {
				tryToSkill1(ship);
			}

			if (skilPressed2) {
				tryToSkill2(ship);
			}

			if ((System.currentTimeMillis() / 100) % 2 == 0) {
				attackFromAlien(selectAttackAlien(entities));
			}


			// we want each frame to take 10 milliseconds, to do this
			// we've recorded when we started the frame. We add 10 milliseconds
			// to this and then factor in the current time to give 
			// us our final value to wait for
			SystemTimer.sleep(lastLoopTime+10-SystemTimer.getTime());
		}
	}

	/**
	 * A class to handle keyboard input from the user. The class
	 * handles both dynamic input during game play, i.e. left/right
	 * and shoot, and more static type input (i.e. press any key to
	 * continue)
	 *
	 * This has been implemented as an inner class more through
	 * habbit then anything else. Its perfectly normal to implement
	 * this as seperate class if slight less convienient.
	 *
	 * @author Kevin Glass
	 */
	private class KeyInputHandler extends KeyAdapter {
		/** The number of key presses we've had while waiting for an "any key" press */
		private int pressCount = 1;

		/**
		 * Notification from AWT that a key has been pressed. Note that
		 * a key being pressed is equal to being pushed down but *NOT*
		 * released. Thats where keyTyped() comes in.
		 *
		 * @param e The details of the key that was pressed
		 */
		public void keyPressed(KeyEvent e) {
			// if we're waiting for an "any key" typed then we don't 
			// want to do anything with just a "press"
			if (waitingForKeyPress) {
				return;
			}


			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				firePressed = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_Z) {
				skilPressed1 = true;
			}
			if (e.getKeyCode() == KeyEvent.VK_X) {
				skilPressed2 = true;
			}
		}

		/**
		 * Notification from AWT that a key has been released.
		 *
		 * @param e The details of the key that was released
		 */
		public void keyReleased(KeyEvent e) {
			// if we're waiting for an "any key" typed then we don't 
			// want to do anything with just a "released"
			if (waitingForKeyPress) {
				return;
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				leftPressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				rightPressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				firePressed = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_Z) {
				skilPressed1 = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_X) {
				skilPressed2 = false;
			}
		}

		/**
		 * Notification from AWT that a key has been typed. Note that
		 * typing a key means to both press and then release it.
		 *
		 * @param e The details of the key that was typed.
		 */
		public void keyTyped(KeyEvent e) {
			// if we're waiting for a "any key" type then
			// check if we've recieved any recently. We may
			// have had a keyType() event from the user releasing
			// the shoot or move keys, hence the use of the "pressCount"
			// counter.
			if (waitingForKeyPress) {
				if (pressCount == 1) {
					// since we've now recieved our key typed
					// event we can mark it as such and start 
					// our new game
					waitingForKeyPress = false;
					startGame();
					pressCount = 0;
				} else {
					pressCount++;
				}
			}

			// if we hit escape, then quit the game
			if (e.getKeyChar() == 27) {
				System.exit(0);
			}
		}
	}

	// method added by Eungyu
	public void addItem(Entity entity) {
		itemList.add(entity);
		System.out.println("Item Added");
	}
	public void removeItem(Entity entity) {
		itemList.remove(entity);
	}
	public double getmoveSpeed() {
		return moveSpeed;
	}
	public double setmoveSpeed(double moveSpeed) {
		return this.moveSpeed = moveSpeed;
	}
	/**
	 * The entry point into the game. We'll simply create an
	 * instance of class which will start the display and game
	 * loop.
	 *
	 * @param argv The arguments that are passed into our game
	 */
	public static void main(String argv[]) {
		Game g = new Game();
		g.mainPage();

		// Start the main game loop, note: this method will not
		// return until the game has finished running. Hence we are
		// using the actual main thread to run the game.
		g.gameLoop();
	}
}
