package com.example.demotestapp;

import com.example.demotestapp.controller.GameController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class, GameController.class})
@AutoConfigureMockMvc
class DemoTestAppApplicationTests {

//	@Autowired
//	private GameController gameController;
//
//	@Autowired
//	private MockMvc mvc;
//
//	@Mock
//	private Model model;
//
//	@Autowired
//	private  GameData gameData;
//
//	@Before
//	public void setUp() {
//		mvc = MockMvcBuilders.standaloneSetup(gameController).build();
//		reset(model);
//
//	}
//
//	@Test
//	public void testStartGame() throws Exception {
//		mvc.perform(get("/"))
//				.andExpect(status().isOk())
//				.andExpect(view().name("index"));
//	}
//
//	@Test
//	public void testWinner() throws Exception {
//		gameData.getPit(7).setStones(5); //player 1
//		gameData.getPit(0).setStones(11); //player 2
//		int winner = gameData.checkPlayerWon();
//
//		assertEquals(2, winner); // Player 2 has more stones and is winning in this case
//	}
//
//	@Test
//	public void testCheckGameOver() { //ends when all pits from[1-6] are Zero(0)
//		for (int i = 1; i <= 6; i++) {
//			gameData.getPit(i).setStones(0);
//		}
//		boolean result = gameData.checkGameOver();
//		assertTrue(result);
//	}
//
//	@Test
//	public void checkCurrentPlayer() {
//		for (int i = 1; i <= 6; i++) {
//			gameData.getPit(i).setStones(3);
//		}
//		boolean result = gameData.checkCurrentPlayer();
//		assertTrue(result, "// expects player 1 to be the current player");
//	}
//
//	@Test
//	public void checkCurrentPlayer2nd() {
//		for (int i = 1; i <= 6; i++) {
//			gameData.getPit(i).setStones(0);
//		}
//		boolean result = gameData.checkCurrentPlayer();
//		assertFalse(result, "// expects 2 should be the current player");
//	}
//
//	@Test
//	public void testMakeValidMove() {
//		gameData.getPit(1).setStones(3);
//		boolean result = gameData.makeValidMove(1);
//		assertTrue(result, "Move should be valid"); //there 3 stones in the pit move is valid
//	}
//
//	@Test
//	public void testMakeInvalidMove() {
//		gameData.getPit(1).setStones(0); //
//		boolean result = gameData.makeValidMove(1);
//		assertFalse(result, "Move should be invalid"); // there are no stones in the pit move is invalid
//	}
//
//	@Test
//	public void testCollectStones() {
//		gameData.getPit(1).setStones(1);
//		gameData.getPit(8).setStones(1);
//
//		gameData.collectStones(1);
//
//		assertEquals(0, gameData.getPit(1).getStones());
//		assertEquals(1, gameData.getPit(8).getStones());
////		assertEquals(2, gameData.getPit(7).getStones());
//	}
//
//	@Test
//	public void testSetMove() {
//		gameData.getPit(0).setStones(3);
//		gameData.getPit(1).setStones(3);
//		gameData.setMove(0); //make move here
//		assertEquals(0, gameData.getPit(0).getStones());
//	}
//
//	@Test
//	public void testGamePlay() {
//		gameData.getPit(13).setStones(4);
//		gameData.getPit(12).setStones(2);
//
//		String gamePlayResult = GameData.gamePlay(gameData);
//		String expectedGamePlayResult = "4 2 6 6 6 6 6 \n6 6 6 6 6 6 6 "; // add expected values
//		assertEquals(expectedGamePlayResult, gamePlayResult);
//	}

	@Test
	void contextLoads() {
	}

}
