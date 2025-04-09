package cscd212tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import cscd212classes.lifeform.Human;
import cscd212classes.lifeform.Martian;
import cscd212classes.lifeform.StarBellySneetch;
import cscd212classes.recovery.RecoveryFractional;
import cscd212classes.recovery.RecoveryLinear;
import cscd212classes.recovery.RecoveryNone;
import cscd212interfaces.recovery.RecoveryBehavior;

public class CSCD212Lab4Test
{
   private String testName;
   private int testCurrentLifePoints;
   private int testMaxLifePoints;
   private RecoveryBehavior testRecoveryFractional;
   private RecoveryBehavior testRecoveryLinear;
   private RecoveryBehavior testRecoveryNone;
   private int testArmorPoints;
   private int testDamage;
   private Human testHuman;
   private Martian testMartian;
   private StarBellySneetch testStarBellySneetch;

   @BeforeEach
   public void initilizeFields()
   {
      this.testName = "Test Name";
      this.testCurrentLifePoints = 100;
      this.testMaxLifePoints = 110;
      this.testRecoveryFractional = new RecoveryFractional(0.30);
      this.testRecoveryLinear = new RecoveryLinear(30);
      this.testRecoveryNone = new RecoveryNone();
      this.testArmorPoints = 50;
      this.testDamage = 10;
      this.testHuman = new Human(this.testName, this.testCurrentLifePoints,
              this.testMaxLifePoints, this.testArmorPoints);
      this.testMartian = new Martian(this.testName, this.testCurrentLifePoints, this.testMaxLifePoints,
            this.testRecoveryFractional);
      this.testStarBellySneetch = new StarBellySneetch(this.testName, this.testCurrentLifePoints,
            this.testMaxLifePoints, this.testRecoveryFractional);
   }

   @Nested
   @DisplayName("Preconditions")
   public class TestPreconditions
   {
      @Nested
      @DisplayName("LifeForms")
      public class TestPreconditionsLifeforms
      {
         @Test
         @DisplayName("exception on name is null")
         public void nameIsNull()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(null, CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testMaxLifePoints,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("exception on name is an empty String")
         public void nameIsEmpty()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(new String(""),
                       CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testMaxLifePoints,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("exception on max life points < 0")
         public void maxLifeLessThanZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(CSCD212Lab4Test.this.testName, -1,
                       CSCD212Lab4Test.this.testMaxLifePoints,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("exception on max life points = 0")
         public void maxLifeIsZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(CSCD212Lab4Test.this.testName, 0,
                       CSCD212Lab4Test.this.testMaxLifePoints,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("exception on current life points < 0")
         public void currentLifeLessThanZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(CSCD212Lab4Test.this.testName,
                       CSCD212Lab4Test.this.testCurrentLifePoints, -1,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("exception on current life points = 0")
         public void currentLifeIsZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(CSCD212Lab4Test.this.testName,
                       CSCD212Lab4Test.this.testCurrentLifePoints, 0,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("exception on max life points less than current")
         public void maxLessThanCurrent()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(CSCD212Lab4Test.this.testName, 5, 4,
                       CSCD212Lab4Test.this.testArmorPoints);
            });
         }

         @Test
         @DisplayName("no exception on max life points = current")
         public void maxEqualsCurrent()
         {
            try
            {
               new Human(CSCD212Lab4Test.this.testName,
                       CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testArmorPoints);
            } catch (final IllegalArgumentException e) {
               fail("LifeForm Constructor threw an exception on a valid paramater (current = max)");
            }
         }
      }

      @Nested
      @DisplayName("Humans")
      public class TestPreconditionsHumans
      {
         @Nested
         @DisplayName("Constructor exception message is correct")
         class ConstructorExceptionMessage {

            @Test
            void nullName() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Human(null,
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testArmorPoints);
               });

               assertEquals("Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for null name,");
            }

            @Test
            void blankName() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Human(new String(""),
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testArmorPoints);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for empty name,");
            }

            @Test
            void negLP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Human(CSCD212Lab4Test.this.testName, -1,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testArmorPoints);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for current life points < 0,");
            }

            @Test
            void negMaxLP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Human(CSCD212Lab4Test.this.testName,
                          CSCD212Lab4Test.this.testCurrentLifePoints, -1,
                          CSCD212Lab4Test.this.testArmorPoints);
               });
               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for max life points < 0,");
            }

            @Test
            void LPmoreThenMex() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Human(CSCD212Lab4Test.this.testName, 5, 4,
                          CSCD212Lab4Test.this.testArmorPoints);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for max life points less than current,");
            }

            @Test
            void negAP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Human(CSCD212Lab4Test.this.testName,
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints, -1);
               });
               assertEquals(
                       "Bad Params in Human Constructor", exception.getMessage(),
                       "Incorrect exception message for negative armor points,");
            }

         }

         @Test
         @DisplayName("constructor exception on armor less than 0")
         public void armorLessThanZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Human(CSCD212Lab4Test.this.testName,
                       CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testMaxLifePoints, -1);
            });
         }

         @Test
         @DisplayName("no construction exception on armor = 0")
         public void armorIsZero()
         {
            try
            {
               new Human(CSCD212Lab4Test.this.testName,
                       CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testMaxLifePoints, 0);
            } catch (final IllegalArgumentException e)
            {
               fail("Human Constructor threw an exception on a valid paramater (armor = 0)");
            }
         }

         @Test
         @DisplayName("setArmor exception message is correct")
         public void setArmorExceptionMessage()
         {
            Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testHuman.setArmorPoints(-1);
            });

            assertEquals( "Bad Params in setArmorPoints",
                  exception.getMessage(),
                    "Incorrect exception message setArmor,");
         }

         @Test
         @DisplayName("setArmorPoints exception on armor less than 0")
         public void setArmorLessThanZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testHuman.setArmorPoints(-1);
            });
         }

         @Test
         @DisplayName("no setArmorPoints exception on armor = 0")
         public void setArmorIsZero()
         {
            try
            {
               CSCD212Lab4Test.this.testHuman.setArmorPoints(0);
            } catch (final IllegalArgumentException e)
            {
               fail("Human setArmorPoints threw an exception on a valid paramater (armor = 0)");
            }
         }

         @Nested
         @DisplayName("takeHit exception message is correct")
         class TakeHitExceptionMessage {

            @Test
            void negDamage() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  CSCD212Lab4Test.this.testHuman.takeHit(-1);
               });

               assertEquals( "Bad Params in takeHit",
                       exception.getMessage(),
                       "Incorrect exception message for Human takeHit,");
            }

            @Test
            void zeroDamage() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  CSCD212Lab4Test.this.testHuman.takeHit(0);
               });

               assertEquals( "Bad Params in takeHit",
                       exception.getMessage(),
                       "Incorrect exception message for Human takeHit,");
            }

         }

         @Test
         @DisplayName("takeHit exception on damage less than 0")
         public void takeHitLessThanZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testHuman.takeHit(-1);
            });
         }

         @Test
         @DisplayName("takeHit exception on damage = 0")
         public void takeHitIsZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testHuman.takeHit(0);
            });
         }

         @Test
         @DisplayName("no takeHit exception on damage > 0")
         public void takeHitIsOne()
         {
            try
            {
               CSCD212Lab4Test.this.testHuman.takeHit(1);
            } catch (final IllegalArgumentException e)
            {
               fail("Human setArmorPoints threw an exception on a valid paramater (armor = 0)");
            }
         }

      }

      @Nested
      @DisplayName("Aliens")
      public class TestPreconditionsAliens
      {
         @Test
         @DisplayName("exception on null recovery")
         public void recoveryIsNull()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               new Martian(CSCD212Lab4Test.this.testName,
                       CSCD212Lab4Test.this.testCurrentLifePoints,
                       CSCD212Lab4Test.this.testMaxLifePoints, null);
            });
         }

         @Nested
         @DisplayName("setCurrentLifePoints exception message is correct")
         class TakeHitExceptionMessage {
            @Test
            void neg() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(-1);
               });

               assertEquals(
                       "Bad Params in setCurrentLifePoints", exception.getMessage(),
                       "Incorrect exception message for setCurrentLifePoints,");
            }

            @Test
            void zero() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(0);
               });

               assertEquals(
                       "Bad Params in setCurrentLifePoints", exception.getMessage(),
                       "Incorrect exception message for setCurrentLifePoints,");
            }

            @Test
            void moreThenMax() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testMaxLifePoints + 10);
               });

               assertEquals(
                       "Bad Params in setCurrentLifePoints", exception.getMessage(),
                       "Incorrect exception message for setCurrentLifePoints,");
            }
         }

         @Test
         @DisplayName("setCurrentLifePoints exception on points < 0")
         public void setCurrentLifePointsLessThanZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(-1);
            });
         }

         @Test
         @DisplayName("setCurrentLifePoints exception on points = 0")
         public void setCurrentLifePointsIsZero()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(0);
            });
         }

         @Test
         @DisplayName("setCurrentLifePoints exception on points > max")
         public void setCurrentLifePointsGreaterThanMax()
         {
            assertThrows(IllegalArgumentException.class, () -> {
               CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testMaxLifePoints + 10);
            });
         }
      }

      @Nested
      @DisplayName("Martians")
      public class TestPreconditionsMartians
      {

         @Nested
         @DisplayName("Constructor exception message is correct")
         class ConstructorExceptionMessage {

            @Test
            void nullName() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Martian(null, CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for null name,");
            }

            @Test
            void blankName() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Martian(new String(""),
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for empty name,");
            }

            @Test
            void negLP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Martian(CSCD212Lab4Test.this.testName, -1,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for current life points < 0,");
            }

            @Test
            void negMexLP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Martian(CSCD212Lab4Test.this.testName,
                          CSCD212Lab4Test.this.testCurrentLifePoints, -1,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });
               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for max life points < 0,");
            }

            @Test
            void LPMoreThenMax() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Martian(CSCD212Lab4Test.this.testName, 5, 4,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for max life points less than current,");
            }

            @Test
            void nullRecovery() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new Martian(CSCD212Lab4Test.this.testName,
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints, null);
               });
               assertEquals(
                       "Bad Params in Alien Constructor", exception.getMessage(),
                       "Incorrect exception message for negative armor points,");
            }

         }


      }

      @Nested
      @DisplayName("StarBellySneetchs")
      public class TestPreconditionsStarBellySneetch
      {

         @Nested
         @DisplayName("Constructor exception message is correct")
         class ConstructorExceptionMessage {

            @Test
            void nullName() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new StarBellySneetch(null,
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for null name,");
            }

            @Test
            void blankName() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new StarBellySneetch(new String(""),
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for empty name,");
            }

            @Test
            void negLP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new StarBellySneetch(CSCD212Lab4Test.this.testName, -1,
                          CSCD212Lab4Test.this.testMaxLifePoints,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for current life points < 0,");
            }

            @Test
            void negMexLP() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new StarBellySneetch(CSCD212Lab4Test.this.testName,
                          CSCD212Lab4Test.this.testCurrentLifePoints, -1,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });
               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for max life points < 0,");
            }

            @Test
            void LPMoreThenMex() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new StarBellySneetch(CSCD212Lab4Test.this.testName, 5, 4,
                          CSCD212Lab4Test.this.testRecoveryFractional);
               });

               assertEquals(
                       "Bad Params in LifeForm Constructor", exception.getMessage(),
                       "Incorrect exception message for max life points less than current,");
            }

            @Test
            void nullRecovery() {
               Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
                  new StarBellySneetch(CSCD212Lab4Test.this.testName,
                          CSCD212Lab4Test.this.testCurrentLifePoints,
                          CSCD212Lab4Test.this.testMaxLifePoints, null);
               });
               assertEquals(
                       "Bad Params in Alien Constructor", exception.getMessage(),
                       "Incorrect exception message for negative armor points,");
            }

         }

      }
   }

   @Nested
   @DisplayName("Martian")
   public class TestMartian
   {
      @Test
      @DisplayName("getLifePoints works")
      public void getLifePointsWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("getName works")
      public void getNameWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testName,
                 CSCD212Lab4Test.this.testMartian.getName());
      }

      @Test
      @DisplayName("takeHit works for damage < life points")
      public void takeHitWorksLowDamage()
      {
         int newLifePoints = CSCD212Lab4Test.this.testCurrentLifePoints - CSCD212Lab4Test.this.testDamage;
         CSCD212Lab4Test.this.testMartian.takeHit(CSCD212Lab4Test.this.testDamage);
         assertEquals(newLifePoints, CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage = life points")
      public void takeHitWorksEqualDamage()
      {
         CSCD212Lab4Test.this.testMartian.takeHit(CSCD212Lab4Test.this.testCurrentLifePoints);
         assertEquals(0, CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage > life points")
      public void takeHitWorksLargeDamage()
      {
         CSCD212Lab4Test.this.testMartian.takeHit(1000);
         assertEquals(0, CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("toString works")
      public void toStringWorks()
      {
         assertEquals(
                 CSCD212Lab4Test.this.testName + " has " + CSCD212Lab4Test.this.testCurrentLifePoints
                     + " life points and has recovery mode of RecoveryFractional",
                 CSCD212Lab4Test.this.testMartian.toString());
      }

      @Test
      @DisplayName("setCurrentLifePoints works")
      public void setCurrentLifePointsWorks()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 10);
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 10,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("getRecoveryBehavior works")
      public void getRecoveryBehaviorWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testRecoveryFractional,
                 CSCD212Lab4Test.this.testMartian.getRecoveryBehavior());
      }

      @Test
      @DisplayName("setRecoveryBehavior works")
      public void setRecoveryBehaviorWorks()
      {
         CSCD212Lab4Test.this.testMartian.setRecoveryBehavior(CSCD212Lab4Test.this.testRecoveryLinear);
         assertEquals(CSCD212Lab4Test.this.testRecoveryLinear,
                 CSCD212Lab4Test.this.testMartian.getRecoveryBehavior());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional above base")
      public void recoverWorksFractionalAboveBase()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 50);
         assertEquals("Test Name has had 15 recovery points added their current life points",
                 CSCD212Lab4Test.this.testMartian.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 50 + 15,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional below base")
      public void recoverWorksFractionalBelowBase()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 90);
         assertEquals("Test Name has had 10 recovery points added their current life points",
                 CSCD212Lab4Test.this.testMartian.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 90 + 10,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional hitting max")
      public void recoverWorksFractionalHittingMax()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 10);
         assertEquals("Test Name has had 20 recovery points added their current life points",
                 CSCD212Lab4Test.this.testMartian.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 10 + 20,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryLinear below max")
      public void recoverWorksLinearBelowMax()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 50);
         CSCD212Lab4Test.this.testMartian.setRecoveryBehavior(CSCD212Lab4Test.this.testRecoveryLinear);
         assertEquals("Test Name has had 30 recovery points added their current life points",
                 CSCD212Lab4Test.this.testMartian.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 50 + 30,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional hitting max")
      public void recoverWorksLinearHittingMax()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 5);
         CSCD212Lab4Test.this.testMartian.setRecoveryBehavior(CSCD212Lab4Test.this.testRecoveryLinear);
         assertEquals("Test Name has had 15 recovery points added their current life points",
                 CSCD212Lab4Test.this.testMartian.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 5 + 15,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryNone")
      public void recoverWorksNone()
      {
         CSCD212Lab4Test.this.testMartian.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 5);
         CSCD212Lab4Test.this.testMartian.setRecoveryBehavior(CSCD212Lab4Test.this.testRecoveryNone);
         assertEquals("Test Name has had 0 recovery points added their current life points",
                 CSCD212Lab4Test.this.testMartian.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 5,
                 CSCD212Lab4Test.this.testMartian.getLifePoints());
      }
   }

   @Nested
   @DisplayName("StarBellySneetch")
   public class TestStarBellySneetch
   {
      @Test
      @DisplayName("getLifePoints works")
      public void getLifePointsWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("getName works")
      public void getNameWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testName,
                 CSCD212Lab4Test.this.testStarBellySneetch.getName());
      }

      @Test
      @DisplayName("takeHit works for damage < life points")
      public void takeHitWorksLowDamage()
      {
         int newLifePoints = CSCD212Lab4Test.this.testCurrentLifePoints - CSCD212Lab4Test.this.testDamage;
         CSCD212Lab4Test.this.testStarBellySneetch.takeHit(CSCD212Lab4Test.this.testDamage);
         assertEquals(newLifePoints, CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage = life points")
      public void takeHitWorksEqualDamage()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.takeHit(CSCD212Lab4Test.this.testCurrentLifePoints);
         assertEquals(0, CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage > life points")
      public void takeHitWorksLargeDamage()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.takeHit(1000);
         assertEquals(0, CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("toString works")
      public void toStringWorks()
      {
         assertEquals(
                 CSCD212Lab4Test.this.testName + " has " + CSCD212Lab4Test.this.testCurrentLifePoints
                     + " life points and has recovery mode of RecoveryFractional",
                 CSCD212Lab4Test.this.testStarBellySneetch.toString());
      }

      @Test
      @DisplayName("setCurrentLifePoints works")
      public void setCurrentLifePointsWorks()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(
                 CSCD212Lab4Test.this.testCurrentLifePoints - 10);
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 10,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("getRecoveryBehavior works")
      public void getRecoveryBehaviorWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testRecoveryFractional,
                 CSCD212Lab4Test.this.testStarBellySneetch.getRecoveryBehavior());
      }

      @Test
      @DisplayName("setRecoveryBehavior works")
      public void setRecoveryBehaviorWorks()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setRecoveryBehavior(
                 CSCD212Lab4Test.this.testRecoveryLinear);
         assertEquals(CSCD212Lab4Test.this.testRecoveryLinear,
                 CSCD212Lab4Test.this.testStarBellySneetch.getRecoveryBehavior());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional above base")
      public void recoverWorksFractionalAboveBase()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(
                 CSCD212Lab4Test.this.testCurrentLifePoints - 50);
         assertEquals("Test Name has had 15 recovery points added their current life points",
                 CSCD212Lab4Test.this.testStarBellySneetch.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 50 + 15,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional below base")
      public void recoverWorksFractionalBelowBase()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(
                 CSCD212Lab4Test.this.testCurrentLifePoints - 90);
         assertEquals("Test Name has had 10 recovery points added their current life points",
                 CSCD212Lab4Test.this.testStarBellySneetch.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 90 + 10,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional hitting max")
      public void recoverWorksFractionalHittingMax()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(
                 CSCD212Lab4Test.this.testCurrentLifePoints - 10);
         assertEquals("Test Name has had 20 recovery points added their current life points",
                 CSCD212Lab4Test.this.testStarBellySneetch.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 10 + 20,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryLinear below max")
      public void recoverWorksLinearBelowMax()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(
                 CSCD212Lab4Test.this.testCurrentLifePoints - 50);
         CSCD212Lab4Test.this.testStarBellySneetch.setRecoveryBehavior(
                 CSCD212Lab4Test.this.testRecoveryLinear);
         assertEquals("Test Name has had 30 recovery points added their current life points",
                 CSCD212Lab4Test.this.testStarBellySneetch.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 50 + 30,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryFractional hitting max")
      public void recoverWorksLinearHittingMax()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 5);
         CSCD212Lab4Test.this.testStarBellySneetch.setRecoveryBehavior(CSCD212Lab4Test.this.testRecoveryLinear);
         assertEquals("Test Name has had 15 recovery points added their current life points",
                 CSCD212Lab4Test.this.testStarBellySneetch.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 5 + 15,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }

      @Test
      @DisplayName("recover works with RecoveryNone")
      public void recoverWorksNone()
      {
         CSCD212Lab4Test.this.testStarBellySneetch.setCurrentLifePoints(CSCD212Lab4Test.this.testCurrentLifePoints - 5);
         CSCD212Lab4Test.this.testStarBellySneetch.setRecoveryBehavior(CSCD212Lab4Test.this.testRecoveryNone);
         assertEquals("Test Name has had 0 recovery points added their current life points",
                 CSCD212Lab4Test.this.testStarBellySneetch.recover());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints - 5,
                 CSCD212Lab4Test.this.testStarBellySneetch.getLifePoints());
      }
   }

   @Nested
   @DisplayName("Human")
   public class TestHuman
   {
      @Test
      @DisplayName("getLifePoints works")
      public void getLifePointsWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints, CSCD212Lab4Test.this.testHuman.getLifePoints());
      }

      @Test
      @DisplayName("getName works")
      public void getNameWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testName, CSCD212Lab4Test.this.testHuman.getName());
      }

      @Test
      @DisplayName("takeHit works for damage < armor points")
      public void takeHitWorksLowDamage()
      {
         int newArmorPoints = CSCD212Lab4Test.this.testArmorPoints - CSCD212Lab4Test.this.testDamage;
         CSCD212Lab4Test.this.testHuman.takeHit(CSCD212Lab4Test.this.testDamage);
         assertEquals(newArmorPoints, CSCD212Lab4Test.this.testHuman.getArmorPoints());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints, CSCD212Lab4Test.this.testHuman.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage = armor points")
      public void takeHitWorksEqualDamage()
      {
         CSCD212Lab4Test.this.testHuman.takeHit(CSCD212Lab4Test.this.testArmorPoints);
         assertEquals(0, CSCD212Lab4Test.this.testHuman.getArmorPoints());
         assertEquals(CSCD212Lab4Test.this.testCurrentLifePoints, CSCD212Lab4Test.this.testHuman.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage > armor points but < armor + life")
      public void takeHitWorksLargeDamage()
      {
         CSCD212Lab4Test.this.testHuman.takeHit(CSCD212Lab4Test.this.testArmorPoints +
                 CSCD212Lab4Test.this.testCurrentLifePoints - 10);
         assertEquals(0, CSCD212Lab4Test.this.testHuman.getArmorPoints());
         assertEquals(10, CSCD212Lab4Test.this.testHuman.getLifePoints());
      }

      @Test
      @DisplayName("takeHit works for damage > armor + life")
      public void takeHitWorksFatalDamage()
      {
         CSCD212Lab4Test.this.testHuman.takeHit(CSCD212Lab4Test.this.testArmorPoints +
                 CSCD212Lab4Test.this.testCurrentLifePoints + 10);
         assertEquals(0, CSCD212Lab4Test.this.testHuman.getArmorPoints());
         assertEquals(0, CSCD212Lab4Test.this.testHuman.getLifePoints());
      }

      @Test
      @DisplayName("toString works")
      public void toStringWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testName + " has " +
                 CSCD212Lab4Test.this.testCurrentLifePoints + " life points and "
               + CSCD212Lab4Test.this.testArmorPoints + " armor points",
                 CSCD212Lab4Test.this.testHuman.toString());
      }

      @Test
      @DisplayName("getArmorPoints works")
      public void getArmorPointsWorks()
      {
         assertEquals(CSCD212Lab4Test.this.testArmorPoints, CSCD212Lab4Test.this.testHuman.getArmorPoints());
      }

      @Test
      @DisplayName("setArmorPoints works")
      public void setArmorPointsWorks()
      {
         CSCD212Lab4Test.this.testHuman.setArmorPoints(CSCD212Lab4Test.this.testArmorPoints - 10);
         assertEquals(CSCD212Lab4Test.this.testArmorPoints - 10,
                 CSCD212Lab4Test.this.testHuman.getArmorPoints());
      }

   }
}
