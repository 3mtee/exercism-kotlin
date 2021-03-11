import Orientation.*

class RobotSimulator(
    gridPosition: GridPosition,
    orientation: Orientation
) {
    var gridPosition: GridPosition = gridPosition
        private set
    var orientation: Orientation = orientation
        private set

    constructor() : this(GridPosition(), NORTH)

    fun simulate(instructions: String) = instructions
        .asSequence()
        .forEach {
            when (it) {
                'L' -> orientation = orientation.rotateLeft()
                'R' -> orientation = orientation.rotateRight()
                'A' -> advance()
            }
        }

    private fun advance() = when (orientation) {
        NORTH -> gridPosition.y += 1
        EAST -> gridPosition.x += 1
        SOUTH -> gridPosition.y -= 1
        WEST -> gridPosition.x -= 1
    }
}
