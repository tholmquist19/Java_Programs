package cscd211tests.lab3;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import cscd212classes.lab3.Team;
import cscd212classes.lab3.players.BaseballPlayer;
import cscd212classes.lab3.players.FootballPlayer;
import cscd212classes.lab3.players.HockeyPlayer;
import cscd212classes.lab3.players.Player;
import cscd212comparators.lab3.TeamPayrollComparator;
import cscd212interfaces.lab3.Payroll;
//import cscd212methods.lab3.CSCD212Lab3Methods;
//import cscd212utils.fileutils.FileUtils;



public class CSCD212Lab3Test {
	private String testName;
	private String testSSN;
	private int testSalary;
	private DecimalFormat fmt;
	private String testPosition;
	private int testTD;
	private int testJerseyNumber;
	private FootballPlayer testFootballPlayer;
	private HockeyPlayer testHockeyPlayer;
	private double testBatAvg;
	private BaseballPlayer testBaseballPlayer;
	private String testCity;
	private String testTeamName;
	private Player[] testPlayersArray = new Player[3];
	private Team testTeam;
	private ArrayList<Player> testPlayers = new ArrayList<Player>();

	@BeforeEach
	public void initilizeFields() {
		testName = "Test Name";
		testSSN = "Test SSN";
		testSalary = 999999;
		testPosition = "Test Position";
		testTD = 99;
		fmt = new DecimalFormat("$#,###,###,###.00");
		testJerseyNumber = 999;
		testFootballPlayer = new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD, testJerseyNumber);
		testHockeyPlayer = new HockeyPlayer(testName, testSSN, testSalary, testPosition, testJerseyNumber);
		testBatAvg = 999;
		testBaseballPlayer = new BaseballPlayer(testName, testSSN, testSalary, testPosition, testBatAvg);
		testCity = "Test City";
		testTeamName = "Test Team Name";
		testPlayersArray[0] = new BaseballPlayer(testName, testSSN, testSalary, testPosition, testBatAvg);
		testPlayersArray[1] = new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD, testJerseyNumber);
		testPlayersArray[2] = new HockeyPlayer(testName, testSSN, testSalary, testPosition, testJerseyNumber);
		testPlayers.add(new BaseballPlayer(testName, testSSN, testSalary, testPosition, testBatAvg));
		testPlayers.add(new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD, testJerseyNumber));
		testPlayers.add(new HockeyPlayer(testName, testSSN, testSalary, testPosition, testJerseyNumber));
		try {
			testTeam = new Team(testCity, testTeamName, testPlayersArray);
		} catch (CloneNotSupportedException e) {
			fail("All clones in Team constructor should be supported but threw a CloneNotSupportedException instead");
		}
	}

	@Nested
	@DisplayName("A FootballPlayer")
	public class TestFootballPlayer {

		@Test
		@DisplayName("is instantiated with new FootballPlayer(String name, String ssn, int salary, String position, int td, int jerseyNumber)")
		public void footballPlayerConstructorWorks() {
			new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD, testJerseyNumber);
		}

		@Nested
		@DisplayName("constructor throws IllegalArgumentException if")
		public class TestFootballPlayerConstructor {

			@Nested
			@DisplayName("super preconditions are not met")
			public class TestSuperPreconditions {

				@Test
				@DisplayName("name is null")
				public void nameIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new FootballPlayer(null, testSSN, testSalary, testPosition, testTD, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("name is an empty String")
				public void nameIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new FootballPlayer(new String(""), testSSN, testSalary, testPosition, testTD, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("ssn is null")
				public void ssnIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new FootballPlayer(testName, null, testSalary, testPosition, testTD, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("ssn is an empty String")
				public void ssnIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new FootballPlayer(testName, new String(""), testSalary, testPosition, testTD,
								testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("position is null")
				public void positionIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new FootballPlayer(testName, testSSN, testSalary, null, testTD, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("position is an empty String")
				public void positionIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new FootballPlayer(testName, testSSN, testSalary, new String(""), testTD, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}
			}

			@Test
			@DisplayName("td is less than 0")
			public void tdLessThanZero() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new FootballPlayer(testName, testSSN, testSalary, testPosition, -1, testJerseyNumber);
				});
				
				assertEquals("Bad Params in FootballPlayer Constructor", exception.getMessage());
			}

			@Test
			@DisplayName("jerseyNumber is less than 0")
			public void jerseyNumberLessThanZero() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD, -1);
				});
				
				assertEquals("Bad Params in FootballPlayer Constructor", exception.getMessage());
			}

			@Nested
			@DisplayName("but does not throw exception on edge cases")
			public class TestFootballPlayerEdgeCases {
				@Test
				@DisplayName("td is 0")
				public void tdZero() {
					try {
						new FootballPlayer(testName, testSSN, testSalary, testPosition, 0, testJerseyNumber);
					} catch (IllegalArgumentException e) {
						fail("Football player should be constructed with 0 touchdowns but an exception was thrown");
					}
				}

				@Test
				@DisplayName("jerseyNumber is 0")
				public void jerseyNumberZero() {
					try {
						new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD, 0);
					} catch (IllegalArgumentException e) {
						fail("Football player should be constructed with 0 for jersey number but an exception was thrown");
					}
				}
			}
		}

		@Test
		@DisplayName("returns the correct String as described in the API when toString() is called")
		public void toStringWorks() {
			assertEquals(testName + "\t\t" + testSSN + "\t\t" + fmt.format(testSalary) + "\t\t" + testPosition + "\t\t"
					+ testTD + "\t\t" + testJerseyNumber, testFootballPlayer.toString());
		}

		@Test
		@DisplayName("returns a new FootballPlayer object which is an exact copy of this when clone() is called")
		public void cloneWorks() {
			FootballPlayer clonedFootballPlayer = null;
			try {
				clonedFootballPlayer = testFootballPlayer.clone();
			} catch (CloneNotSupportedException e) {
				fail("A FootballPlayer clone should be supported but threw a CloneNotSupportedException instead");
			}

			assertNotSame(clonedFootballPlayer, testFootballPlayer);
			assertEquals(testFootballPlayer.toString(), clonedFootballPlayer.toString());

		}
	}

	@Nested
	@DisplayName("A HockeyPlayer")
	public class TestHockeyPlayer {

		@Test
		@DisplayName("is instantiated with new HockeyPlayer(String name, String ssn, int salary, String position, int jerseyNumber)")
		public void HockeyPlayerConstructorWorks() {
			new HockeyPlayer(testName, testSSN, testSalary, testPosition, testJerseyNumber);
		}

		@Nested
		@DisplayName("constructor throws IllegalArgumentException if")
		public class TestHockeyPlayerConstructor {

			@Nested
			@DisplayName("super preconditions are not met")
			public class TestSuperPreconditions {

				@Test
				@DisplayName("name is null")
				public void nameIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new HockeyPlayer(null, testSSN, testSalary, testPosition, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("name is an empty String")
				public void nameIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new HockeyPlayer(new String(""), testSSN, testSalary, testPosition, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("ssn is null")
				public void ssnIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new HockeyPlayer(testName, null, testSalary, testPosition, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("ssn is an empty String")
				public void ssnIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new HockeyPlayer(testName, new String(""), testSalary, testPosition, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("position is null")
				public void positionIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new HockeyPlayer(testName, testSSN, testSalary, null, testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("position is an empty String")
				public void positionIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new HockeyPlayer(testName, testSSN, testSalary, new String(""), testJerseyNumber);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}
			}

			@Test
			@DisplayName("jerseyNumber is less than 0")
			public void jerseyNumberLessThanZero() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new HockeyPlayer(testName, testSSN, testSalary, testPosition, -1);
				});
				
				assertEquals("Bad Params in HockeyPlayer Constructor", exception.getMessage());
			}

			@Nested
			@DisplayName("but does not throw exception on edge cases")
			public class TestHockeyPlayerEdgeCases {

				@Test
				@DisplayName("jerseyNumber is 0")
				public void jerseyNumberZero() {
					try {
						new HockeyPlayer(testName, testSSN, testSalary, testPosition, 0);
					} catch (IllegalArgumentException e) {
						fail("Hockey player should be constructed with 0 for jersey number but an exception was thrown");
					}
				}
			}
		}

		@Test
		@DisplayName("returns the correct String as described in the API when toString() is called")
		public void toStringWorks() {
			assertEquals(testName + "\t\t" + testSSN + "\t\t" + fmt.format(testSalary) + "\t\t" + testPosition + "\t\t"
					+ testJerseyNumber, testHockeyPlayer.toString());
		}

		@Test
		@DisplayName("returns a new HockeyPlayer object which is an exact copy of this when clone() is called")
		public void cloneWorks() {
			HockeyPlayer clonedHockeyPlayer = null;
			try {
				clonedHockeyPlayer = testHockeyPlayer.clone();
			} catch (CloneNotSupportedException e) {
				fail("A HockeyPlayer clone should be supported but threw a CloneNotSupportedException instead");
			}

			assertNotSame(clonedHockeyPlayer, testHockeyPlayer);
			assertEquals(clonedHockeyPlayer.toString(), testHockeyPlayer.toString());

		}
	}

	@Nested
	@DisplayName("A BaseballPlayer")
	public class TestBaseballPlayer {

		@Test
		@DisplayName("is instantiated with new BaseballPlayer(String name, String ssn, int salary, String position, double batAvg)")
		public void BaseballPlayerConstructorWorks() {
			new BaseballPlayer(testName, testSSN, testSalary, testPosition, testBatAvg);
		}

		@Nested
		@DisplayName("constructor throws IllegalArgumentException if")
		public class TestBaseballPlayerConstructor {

			@Nested
			@DisplayName("super preconditions are not met")
			public class TestSuperPreconditions {

				@Test
				@DisplayName("name is null")
				public void nameIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new BaseballPlayer(null, testSSN, testSalary, testPosition, testBatAvg);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("name is an empty String")
				public void nameIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new BaseballPlayer(new String(""), testSSN, testSalary, testPosition, testBatAvg);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("ssn is null")
				public void ssnIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new BaseballPlayer(testName, null, testSalary, testPosition, testBatAvg);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("ssn is an empty String")
				public void ssnIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new BaseballPlayer(testName, new String(""), testSalary, testPosition, testBatAvg);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("position is null")
				public void positionIsNull() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new BaseballPlayer(testName, testSSN, testSalary, null, testBatAvg);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}

				@Test
				@DisplayName("position is an empty String")
				public void positionIsEmptyString() {
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						new BaseballPlayer(testName, testSSN, testSalary, new String(""), testBatAvg);
					});
					
					assertEquals("Bad Params in Player Constructor", exception.getMessage());
				}
			}

			@Test
			@DisplayName("batAvg is less than 0")
			public void batAvgLessThanZero() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new BaseballPlayer(testName, testSSN, testSalary, testPosition, -1);
				});
				
				assertEquals("Bad Params in BaseballPlayer Constructor", exception.getMessage());
			}

			@Nested
			@DisplayName("but does not throw exception on edge cases")
			public class TestBaseballPlayerEdgeCases {

				@Test
				@DisplayName("batAvg is 0")
				public void jerseyNumberZero() {
					try {
						new BaseballPlayer(testName, testSSN, testSalary, testPosition, 0);
					} catch (IllegalArgumentException e) {
						fail("Baseball player should be constructed with 0 for jersey number but an exception was thrown");
					}
				}
			}
		}

		@Test
		@DisplayName("returns the correct String as described in the API when toString() is called")
		public void toStringWorks() {
			assertEquals(testName + "\t\t" + testSSN + "\t\t" + fmt.format(testSalary) + "\t\t" + testPosition + "\t\t"
					+ testBatAvg, testBaseballPlayer.toString());
		}

		@Test
		@DisplayName("returns a new BaseballPlayer object which is an exact copy of this when clone() is called")
		public void cloneWorks() {
			BaseballPlayer clonedBaseballPlayer = null;
			try {
				clonedBaseballPlayer = testBaseballPlayer.clone();
			} catch (CloneNotSupportedException e) {
				fail("A BaseballPlayer clone should be supported but threw a CloneNotSupportedException instead");
			}

			assertNotSame(clonedBaseballPlayer, testBaseballPlayer);
			assertEquals(testBaseballPlayer.toString(), clonedBaseballPlayer.toString());

		}
	}

	@Nested
	@DisplayName("A Team")
	public class TestTeam {

		@Test
		@DisplayName("is instantiated with new Team(String city, String teamName, Player[] players")
		public void isInstantiatedWithNew() {
			try {
				new Team(testCity, testTeamName, testPlayersArray);
			} catch (CloneNotSupportedException e) {
				fail("All clones in Team constructor should be supported but threw a CloneNotSupportedException instead");
			}
		}

		@Nested
		@DisplayName("constructor throws IllegalArgumentException if")
		public class TestTeamConstructor {
			@Test
			@DisplayName("city is null")
			public void cityIsNull() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new Team(null, testTeamName, testPlayersArray);
				});
				
				assertEquals("Bad Params in Team Constructor", exception.getMessage());
			}

			@Test
			@DisplayName("city is an empty String")
			public void cityIsEmptyString() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new Team(new String(""), testTeamName, testPlayersArray);
				});
				
				assertEquals("Bad Params in Team Constructor", exception.getMessage());
			}

			@Test
			@DisplayName("teamName is null")
			public void teamNameIsNull() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new Team(testCity, null, testPlayersArray);
				});
				
				assertEquals("Bad Params in Team Constructor", exception.getMessage());
			}

			@Test
			@DisplayName("teamName is an empty String")
			public void teamNameIsEmptyString() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new Team(testCity, new String(""), testPlayersArray);
				});
				
				assertEquals("Bad Params in Team Constructor", exception.getMessage());
			}

			@Test
			@DisplayName("players array is null")
			public void playersArrayIsNull() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new Team(testCity, testTeamName, null);
				});
				
				assertEquals("Bad Params in Team Constructor", exception.getMessage());
			}

			@Test
			@DisplayName("teamName is an empty String")
			public void playersArrayIsLengthZero() {
				Player[] testEmptyArray = new Player[0];
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					new Team(testCity, testTeamName, testEmptyArray);
				});
				
				assertEquals("Bad Params in Team Constructor", exception.getMessage());
			}
		}

		@Nested
		@DisplayName("methods work properly")
		public class TestTeamMethods {
			@BeforeEach
			public void initializeTestTeam() throws CloneNotSupportedException {
				testTeam = new Team(testCity, testTeamName, testPlayersArray);
			}

			@Test
			@DisplayName("properly returns from getTeamName")
			public void getTeamNameWorks() {
				assertEquals(testTeamName, testTeam.getTeamName());
			}

			@Test
			@DisplayName("properly returns from getPlayers")
			public void getPlayersWorks() {
				assertEquals(testPlayers.toString(), testTeam.getPlayers().toString());
			}

			@Test
			@DisplayName("properly returns from getCity")
			public void getCityWorks() {
				assertEquals(testCity, testTeam.getCity());
			}

			@Test
			@DisplayName("properly returns from getPayroll")
			public void getPayrollsWorks() {
				assertEquals(Payroll.BASE_PAYROLL + 999999 + 999999 + 999999, testTeam.getPayroll());
			}

			@Test
			@DisplayName("properly returns from toString")
			public void toStringWorks() {
				assertEquals(testCity + " - " + testTeamName + "\n" + "Payroll: $14,999,997.00" + "\n"
						+ "----------------------------------------------------------------------------" + "\n"
						+ "Test Name		Test SSN		$999,999.00		Test Position		999.0" + "\n"
						+ "Test Name		Test SSN		$999,999.00		Test Position		99		999" + "\n"
						+ "Test Name		Test SSN		$999,999.00		Test Position		999" + "\n" + "" + "\n"
						+ "", testTeam.toString());
			}

			@Nested
			@DisplayName("when calling compareTo on this with another Team pi")
			public class TestTeamCompareTo {
				@Test
				@DisplayName("throws IllegalArgumentException - If pi is null")
				public void compareToThrowsExceptionIfPiIsNull() {
					Team testPi = null;
					Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
						testTeam.compareTo(testPi);
					});

					assertEquals("Bad Params in compareTo", exception.getMessage());
				}

				@Test
				@DisplayName("returns 0 when objects are the same")
				public void compareToWhenSameObjectWorks() throws CloneNotSupportedException {
					assertEquals(0, testTeam.compareTo(testTeam));
				}

				@Test
				@DisplayName("returns 0 when objects are not the same but have same contents")
				public void compareToWhenSameContentsWorks() throws CloneNotSupportedException {
					Player[] testPlayersArrayPi = new Player[3];
					testPlayersArrayPi[0] = new BaseballPlayer(testName, testSSN, testSalary, testPosition, testBatAvg);
					testPlayersArrayPi[1] = new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD,
							testJerseyNumber);
					testPlayersArrayPi[2] = new HockeyPlayer(testName, testSSN, testSalary, testPosition,
							testJerseyNumber);
					Team testPi = new Team(new String(testCity), new String(testTeamName), testPlayersArrayPi);
					assertEquals(0, testTeam.compareTo(testPi));
				}

				@Test
				@DisplayName("compares by city when everything is different")
				public void compareToComparesFirstByCity() throws CloneNotSupportedException {
					Player[] testPlayersArrayPi = new Player[3];
					testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testBatAvg + 99);
					testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
					testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testJerseyNumber + 99);
					Team testPi = new Team(testCity + " Pi", testTeamName + " Pi", testPlayersArrayPi);
					assertEquals(testCity.compareTo(testCity + " Pi"), testTeam.compareTo(testPi));
				}

				@Test
				@DisplayName("compares by teamName when city is same but everything else is different")
				public void compareToComparesByTeamNameIfCitySame() throws CloneNotSupportedException {
					Player[] testPlayersArrayPi = new Player[3];
					testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testBatAvg + 99);
					testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
					testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testJerseyNumber + 99);
					Team testPi = new Team(testCity, testTeamName + " Pi", testPlayersArrayPi);
					assertEquals(testTeamName.compareTo(testTeamName + " Pi"), testTeam.compareTo(testPi));
				}

				@Test
				@DisplayName("returns 0 when city and teamName are both same but everything else is different")
				public void compareToComparesByTeamNameIfCityAndNameSame() throws CloneNotSupportedException {
					Player[] testPlayersArrayPi = new Player[3];
					testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testBatAvg + 99);
					testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
					testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testJerseyNumber + 99);
					Team testPi = new Team(testCity, testTeamName, testPlayersArrayPi);
					assertEquals(0, testTeam.compareTo(testPi));
				}
				
				@Test
				@DisplayName("returns 0 when city and teamName both have same content but are different objects")
				public void compareToSameContentDifferentObject() throws CloneNotSupportedException {
					Player[] testPlayersArrayPi = new Player[3];
					testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testBatAvg + 99);
					testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
					testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
							testPosition + " Pi", testJerseyNumber + 99);
					Team testPi = new Team(new String(testCity), new String(testTeamName), testPlayersArrayPi);
					assertEquals(0, testTeam.compareTo(testPi));
				}

			}

		}

	}

	@Nested
	@DisplayName("A Payroll Interface")
	public class TestPayroll {
		@Test
		@DisplayName("has its BASE_PAYROLL field set to 12000000")
		public void basePayrollIsCorrect() {
			assertEquals(12000000, Payroll.BASE_PAYROLL);
		}
	}

	@Nested
	@DisplayName("A TeamPayrollComparator")
	public class TestTeamPayrollComparator {
		private TeamPayrollComparator testTPC = new TeamPayrollComparator();

		@Test
		@DisplayName("is instantiated with new TeamPayrollComparator()")
		public void isInstantiatedWithNew() {
			new TeamPayrollComparator();
		}

		@Test
		@DisplayName("throws IllegalArgumentException - If t1 is null")
		public void compareThrowsExceptionIfT1IsNull() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				testTPC.compare(null, testTeam);
			});

			assertEquals("Bad Params in compare", exception.getMessage());
		}

		@Test
		@DisplayName("throws IllegalArgumentException - If t2 is null")
		public void compareToThrowsExceptionIfPiIsNull() {
			Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
				testTPC.compare(testTeam, null);
			});

			assertEquals("Bad Params in compare", exception.getMessage());
		}

		@Test
		@DisplayName("returns 0 when objects are the same")
		public void compareToWhenSameObjectWorks() throws CloneNotSupportedException {
			assertEquals(0, testTPC.compare(testTeam, testTeam));
		}

		@Test
		@DisplayName("returns 0 when objects are not the same but have same contents")
		public void compareToWhenSameContentsWorks() throws CloneNotSupportedException {
			Player[] testPlayersArrayPi = new Player[3];
			testPlayersArrayPi[0] = new BaseballPlayer(testName, testSSN, testSalary, testPosition, testBatAvg);
			testPlayersArrayPi[1] = new FootballPlayer(testName, testSSN, testSalary, testPosition, testTD,
					testJerseyNumber);
			testPlayersArrayPi[2] = new HockeyPlayer(testName, testSSN, testSalary, testPosition, testJerseyNumber);
			Team testTeam2 = new Team(new String(testCity), new String(testTeamName), testPlayersArrayPi);
			assertEquals(0, testTPC.compare(testTeam, testTeam2));
		}

		@Test
		@DisplayName("compares by salary and returns less than 0 when everything is different and t1 <t2 salary")
		public void compareToComparesFirstByCity() throws CloneNotSupportedException {
			Player[] testPlayersArrayPi = new Player[3];
			testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
					testPosition + " Pi", testBatAvg + 99);
			testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
					testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
			testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary + 99,
					testPosition + " Pi", testJerseyNumber + 99);
			Team testTeam2 = new Team(testCity + " Pi", testTeamName + " Pi", testPlayersArrayPi);
			assertTrue(testTPC.compare(testTeam, testTeam2) < 0);
		}

		@Test
		@DisplayName("compares by salary and returns greater than 0 when everything is different and t1 >t2 salary")
		public void compareToComparesByTeamNameIfCitySame() throws CloneNotSupportedException {
			Player[] testPlayersArrayPi = new Player[3];
			testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary - 99,
					testPosition + " Pi", testBatAvg + 99);
			testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary - 99,
					testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
			testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary - 99,
					testPosition + " Pi", testJerseyNumber + 99);
			Team testTeam2 = new Team(testCity + " Pi", testTeamName + " Pi", testPlayersArrayPi);
			assertTrue(testTPC.compare(testTeam, testTeam2) > 0);
		}

		@Test
		@DisplayName("returns 0 when salary same but everything else is different")
		public void compareToComparesByTeamNameIfCityAndNameSame() throws CloneNotSupportedException {
			Player[] testPlayersArrayPi = new Player[3];
			testPlayersArrayPi[0] = new BaseballPlayer(testName + " Pi", testSSN + " Pi", testSalary,
					testPosition + " Pi", testBatAvg + 99);
			testPlayersArrayPi[1] = new FootballPlayer(testName + " Pi", testSSN + " Pi", testSalary,
					testPosition + " Pi", testTD + 99, testJerseyNumber + 99);
			testPlayersArrayPi[2] = new HockeyPlayer(testName + " Pi", testSSN + " Pi", testSalary,
					testPosition + " Pi", testJerseyNumber + 99);
			Team testTeam2 = new Team(testCity + " Pi", testTeamName + " Pi", testPlayersArrayPi);
			assertEquals(0, testTPC.compare(testTeam, testTeam2));
		}
		

	}
	
	@Nested
	@DisplayName("The CSCD212Lab3Methods class")
	public class TestCSCD212Lab3Methods {

		/*@Nested

		@DisplayName("fillArrayList method")
		public class TestFillArrayList {
			private File inf = null;;
			private ArrayList<Team> theTeams = null;
			private Scanner fin = null;

			@BeforeEach
			public void init() {
				theTeams = new ArrayList<Team>();
				try {
					inf = FileUtils.openInputFile("teamlist.txt");
				    fin = new Scanner(inf);
				} catch (FileNotFoundException e) {
					System.out.println("teamlist.txt wasnt found - might wanna look into that");
				}
			}

			@AfterEach
			public void teardown() {
				inf = null;
				theTeams = null;
				fin.close();
				fin = null;
				
			}*/
		
			/*@Test
			@DisplayName("fills the ArrayList correctly when given sample file")
			public void fillArrayListWorksForSampleFile(){


			   *//* try {
					CSCD212Lab3Methods.fillArrayList(fin, theTeams);
				} catch (CloneNotSupportedException e) {
					fail("fillArrayList threw an unexpected CloneNotSupported exception");
				}*//*
			    
			    ArrayList<Team> theTeamsTest = new ArrayList<Team>();
			    Player[] testPlayersSeahawks = new Player[3];
			    Player[] testPlayersMariners = new Player[2];
			    Player[] testPlayersPenguins = new Player[3];
			    Player[] testPlayersSteelers = new Player[2];
			    
			    testPlayersSeahawks[0] = new FootballPlayer("Russell Wilson", "543-34-9965", 22000000, "Quarterback", 120, 3);
			    testPlayersSeahawks[1] = new FootballPlayer("Arthur Copperpants", "992-32-1111", 1500000, "Running Back", 17, 14);
			    testPlayersSeahawks[2] = new FootballPlayer("Peter Piper", "523-55-9911", 300000, "Receiver", 8, 81);
			    testPlayersMariners[0] = new BaseballPlayer("Joe Schmoe", "222-33-9823", 3000000, "Catcher", .245);
			    testPlayersMariners[1] = new BaseballPlayer("Martin Olsen", "234-23-1895", 10000000, "Pitcher", .362);
			    testPlayersPenguins[0] = new HockeyPlayer("Sydney Crosby", "111-33-4444", 90000000, "Centre", 87);
			    testPlayersPenguins[1] = new HockeyPlayer("Ian Cole", "888-77-6666", 200000, "Defense", 28);
			    testPlayersPenguins[2] = new HockeyPlayer("Phil Kessel", "555-11-6666", 1000000, "Right Wing", 81);
			    testPlayersSteelers[0] = new FootballPlayer("Ben Roethlisberger", "123-45-6789", 20000000, "Quarterback", 99, 7);
			    testPlayersSteelers[1] = new FootballPlayer("Keion Adams", "123-46-9876", 100000, "Linebacker", 2, 99);
			    
			    try {
			    	theTeamsTest.add(new Team("Seattle", "Seattle Seahawks",testPlayersSeahawks));
				    theTeamsTest.add(new Team("Seattle", "Seattle Mariners",testPlayersMariners));
				    theTeamsTest.add(new Team("Pittsburgh", "Pittsburgh Penguins",testPlayersPenguins));
					theTeamsTest.add(new Team("Pittsburgh", "Pittsburgh Steelers",testPlayersSteelers));
				} catch (CloneNotSupportedException e) {
					fail("a Team constructor threw an unexpected CloneNotSupported exception");
				}
			    
			    assertEquals(theTeamsTest.toString(), theTeams.toString());
			    
			    

			}*/
			
		/*	@Test
			@DisplayName("throws IllegalArgumentException when fin is null")
			public void fillArrayListThrowsWhenNullFin() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					try {
						CSCD212Lab3Methods.fillArrayList(null, theTeams);
					} catch (CloneNotSupportedException e) {
						fail("fillArrayList threw an unexpected CloneNotSupported exception");
					}
				});

				assertEquals("Bad Params in fillArrayList", exception.getMessage());
			}
			
			@Test
			@DisplayName("throws IllegalArgumentException when myTeam is null")
			public void fillArrayListThrowsWhenNullMyTeam() {
				Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
					try {
						CSCD212Lab3Methods.fillArrayList(fin, null);
					} catch (CloneNotSupportedException e) {
						fail("fillArrayList threw an unexpected CloneNotSupported exception");
					}
				});

				assertEquals("Bad Params in fillArrayList", exception.getMessage());
			}
			
		}*/
	}
}
