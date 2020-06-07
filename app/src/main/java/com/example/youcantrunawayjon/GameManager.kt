package com.example.youcantrunawayjon

class GameManager {
    private var mBoard: CharArray
    private lateinit var currentPositionMap: HashMap<Char, Int>

    companion object {
        const val BOARD_SIZE:Int = 9
        const val J_PLAYER:Char = 'X'
        const val Q_PLAYER:Char = 'O'
        const val OPEN_SPOT:Char = ' '
    }

    init {
        mBoard = CharArray(BOARD_SIZE)
        resetBoard()
    }

    fun getBoardOccupant(i: Int): Char {
        return mBoard[i]
    }

    fun getJCurrentPosition(): Int? {
        return currentPositionMap[J_PLAYER]
    }

    fun setMove(player: Char, location: Int): Boolean {
        require(!(location < 0 || location >= BOARD_SIZE)) { "location must be between 0 and 8 inclusive: $location" }
        mBoard[currentPositionMap[J_PLAYER]!!] = OPEN_SPOT
        mBoard[location] = player
        currentPositionMap[J_PLAYER] = location
        return true
    }

    fun resetBoard() {
        for (i in mBoard.indices) mBoard[i] = OPEN_SPOT
        mBoard[0] = J_PLAYER
        mBoard[2] = Q_PLAYER
        currentPositionMap = hashMapOf(J_PLAYER to 0, Q_PLAYER to 2)
    }

}