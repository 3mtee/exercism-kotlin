import org.junit.Test
import kotlin.test.assertEquals

class RobotSimulatorTest {

    @Test
    fun `brand new - at origin facing north`() =
        RobotSimulator()
            .should {
                face(Orientation.NORTH)
                beAt(x = 0, y = 0)
            }

    @Test
    fun `brand new - at negative position facing south`() =
        RobotSimulator(GridPosition(x = -1, y = -1), Orientation.SOUTH)
            .should {
                face(Orientation.SOUTH)
                beAt(x = -1, y = -1)
            }

    @Test
    fun `rotating clockwise - changes north to east`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("R")
            .should {
                face(Orientation.EAST)
            }

    @Test
    fun `rotating clockwise - changes east to south`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.EAST)
            .instructed("R")
            .should {
                face(Orientation.SOUTH)
            }

    @Test
    fun `rotating clockwise - changes south to west`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.SOUTH)
            .instructed("R")
            .should {
                face(Orientation.WEST)
            }

    @Test
    fun `rotating clockwise - changes west to north`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.WEST)
            .instructed("R")
            .should {
                face(Orientation.NORTH)
            }

    @Test
    fun `rotating counter-clockwise - changes north to west`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("L")
            .should {
                face(Orientation.WEST)
            }

    @Test
    fun `rotating counter-clockwise - changes west to south`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.WEST)
            .instructed("L")
            .should {
                face(Orientation.SOUTH)
            }

    @Test
    fun `rotating counter-clockwise - changes south to east`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.SOUTH)
            .instructed("L")
            .should {
                face(Orientation.EAST)
            }

    @Test
    fun `rotating counter-clockwise - changes east to north`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.EAST)
            .instructed("L")
            .should {
                face(Orientation.NORTH)
            }

    @Test
    fun `moving forward - facing north increments Y`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("A")
            .should {
                face(Orientation.NORTH)
                beAt(x = 0, y = 1)
            }

    @Test
    fun `moving forward - facing south decrements Y`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.SOUTH)
            .instructed("A")
            .should {
                face (Orientation.SOUTH)
                beAt(x = 0, y = -1)
            }

    @Test
    fun `moving forward - facing east increments X`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.EAST)
            .instructed("A")
            .should {
                face (Orientation.EAST)
                beAt(x = 1, y = 0)
            }

    @Test
    fun `moving forward - facing west decrements X`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.WEST)
            .instructed("A")
            .should {
                face (Orientation.WEST)
                beAt(x = -1, y = 0)
            }

    @Test
    fun `series of instructions - moving east and north example`() =
        RobotSimulator(GridPosition(x = 7, y = 3), Orientation.NORTH)
            .instructed("RAALAL")
            .should {
                face(Orientation.WEST)
                beAt(x = 9, y = 4)
            }

    @Test
    fun `series of instructions - moving west and north`() =
        RobotSimulator(GridPosition(x = 0, y = 0), Orientation.NORTH)
            .instructed("LAAARALA")
            .should {
                face(Orientation.WEST)
                beAt(x = -4, y = 1)
            }

    @Test
    fun `series of instructions - moving west and south`() =
        RobotSimulator(GridPosition(x = 2, y = -7), Orientation.EAST)
            .instructed("RRAAAAALA")
            .should {
                face(Orientation.SOUTH)
                beAt(x = -3, y = -8)
            }

    @Test
    fun `series of instructions - moving east and north`() =
        RobotSimulator(GridPosition(x = 8, y = 4), Orientation.SOUTH)
            .instructed("LAAARRRALLLL")
            .should {
                face(Orientation.NORTH)
                beAt(x = 11, y = 5)
            }
}

private fun RobotSimulator.instructed(moves: String): RobotSimulator {
    simulate(moves)
    return this
}

private fun RobotSimulator.should(what: RobotShould.() -> Unit) = what(RobotShould(this))

private class RobotShould(private val robot: RobotSimulator) {
    fun face(expected: Orientation) = assertEquals(expected, robot.orientation)
    fun beAt(x: Int, y: Int) = assertEquals(GridPosition(x = x, y = y), robot.gridPosition)
}
