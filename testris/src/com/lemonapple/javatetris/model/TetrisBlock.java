package com.lemonapple.javatetris.model;

import java.util.Random;

import com.lemonapple.javatetris.controller.TetrisGameController;

public class TetrisBlock {
	public int posX = 0, posY = 0;
	public int[][] block = new int[4][4];
	public int c; // color.
	private TetrisGameController controller;

	public TetrisBlock(TetrisGameController controller) {
		this.controller = controller;
		Random rand = new Random();
		this.c = 1 + rand.nextInt(4);
		setBlock(rand.nextInt(6), 0);
	}

	private void setBlock(int type, int rotation) {
		if (type == 0) {
			block[0] = new int[] { c, 0, 0, 0 };
			block[1] = new int[] { c, 0, 0, 0 };
			block[2] = new int[] { c, 0, 0, 0 };
			block[3] = new int[] { c, 0, 0, 0 };
		} else if (type == 1) {
			block[0] = new int[] { 0, 0, 0, 0 };
			block[1] = new int[] { 0, 0, 0, 0 };
			block[2] = new int[] { c, 0, 0, 0 };
			block[3] = new int[] { c, c, c, 0 };
		} else if (type == 2) {
			block[0] = new int[] { 0, 0, 0, 0 };
			block[1] = new int[] { c, 0, 0, 0 };
			block[2] = new int[] { c, 0, 0, 0 };
			block[3] = new int[] { c, c, 0, 0 };
		} else if (type == 3) {
			block[0] = new int[] { 0, 0, 0, 0 };
			block[1] = new int[] { 0, 0, 0, 0 };
			block[2] = new int[] { c, c, 0, 0 };
			block[3] = new int[] { c, c, 0, 0 };
		} else if (type == 4) {
			block[0] = new int[] { 0, 0, 0, 0 };
			block[1] = new int[] { c, 0, 0, 0 };
			block[2] = new int[] { c, c, 0, 0 };
			block[3] = new int[] { c, 0, 0, 0 };
		} else if (type == 5) {
			block[0] = new int[] { 0, 0, 0, 0 };
			block[1] = new int[] { c, 0, 0, 0 };
			block[2] = new int[] { c, c, 0, 0 };
			block[3] = new int[] { 0, c, 0, 0 };
		} else if (type >= 6) {
			block[0] = new int[] { 0, 0, 0, 0 };
			block[1] = new int[] { 0, 0, 0, 0 };
			block[2] = new int[] { c, c, 0, 0 };
			block[3] = new int[] { 0, c, c, 0 };
		}
		
	}

	public void rotateBlock(TetrisBoard board) {
		int[][] currentBlock = block.clone();
		int[][] nextBlock = new int[4][4];

		// �쉶�쟾 �떆�궓�떎.
		for (int i = 0; i < block.length; i++)
			for (int j = 0; j < block[i].length; j++)
				nextBlock[i][j] = 0;
		for (int i = 0; i < block.length; i++)
			for (int j = 0; j < block[i].length; j++)
				nextBlock[i][j] = block[j][3 - i];

		block = nextBlock;
		trim(); // �씪�떒 �쟻�슜�븯怨�.
		
		int currPOSX = posX;
		boolean isAbleToRotate = false; // �룎由� �닔 �뾾�떎怨� 誘욧퀬.
		for (int i = 0; i < 4; i++) { // 4踰� �떆�룄 �빐蹂몃떎.
			posX = currPOSX - i; // �븳移몄뵫 �븸寃⑤큵.
			if (isAbleToMoveAfterCrachCheck(board, 0, 0)) {// 寃��궗�빐�꽌 �쉶�쟾 媛��뒫 �븯硫�,
				isAbleToRotate = true; // flag瑜� �꽭�슦怨�,
				break; // 猷⑦봽 �깉異�.
			}
		}
		
		if (!isAbleToRotate) { // �쐞 猷⑦봽�뿉�꽌 �븞�맖�씠 �뙋紐낅릺硫�,
			posX = currPOSX;
			block = currentBlock; // �쉶�쟾�긽�깭 �썝�긽 蹂듦�.
		}
		if (posX + getRightBorder() > TetrisBoard.x) {
			// �룎�졇�뒗�뜲, �슦痢≪쑝濡� �굪�졇�굹媛� 寃쎌슦.
			System.out.println("out" + ""
					+ (posX + getRightBorder() - TetrisBoard.x)); // 異쒕젰�븯怨�.
			posX = posX - (posX + getRightBorder() - TetrisBoard.x);
			// �굪�졇�굹媛꾨쭔�겮 �쇊履쎌쑝濡� �븸源�.
		}
		trim();
	}

	public void downBlock(TetrisBoard board) {
		if (isAbleToMoveAfterCrachCheck(board, 0, 1))
			posY = posY + 1;

		trim();
	}

	public void leftBlock(TetrisBoard board) {
		if (posX + getLeftBorder() > 0) { // 醫뚯륫踰� 異⑸룎 寃��궗.
			if (isAbleToMoveAfterCrachCheck(board, -1, 0))
				posX = posX - 1;
		}
		trim();
	}

	public void rightBlock(TetrisBoard board) {
		if (posX + getRightBorder() < TetrisBoard.x) { // �슦痢〓꼍 異⑸룎寃��궗.
			if (isAbleToMoveAfterCrachCheck(board, 1, 0))
				posX = posX + 1;
		}
		trim();
	}

	private boolean isAbleToMoveAfterCrachCheck(TetrisBoard board, int deltaX,
			int deltaY) {
		// CrachCheck
		for (int i = 0; i < block.length; i++) { // 
			for (int j = 0; j < block[i].length; j++) {
				if ((posY + deltaY + j >= TetrisBoard.y)
						|| (posX + deltaX + i >= TetrisBoard.x)) {
					// 
					break;
				}
				if (board.block[posY + deltaY + j][posX + deltaX + i] >= 1
						&& block[j][i] >= 1) { // 
					if (deltaY == 1)
						controller.createNewBlock();
					return false;
				}
			}
		}
		if (posY + deltaY + getDownBorder() > TetrisBoard.y) { // 諛붾떏怨� 異⑸룎 寃��궗.
			controller.createNewBlock();
			return false;
		}
		return true;
	}

	private void trim() {
		int count = getLeftBorder();
		for (int i = 0; i < count; i++) {
			this.arrangeLeft();
		}
	}

	private void arrangeLeft() {
		for (int i = 0; i < block.length; i++)
			for (int j = 1; j < block[i].length; j++) {
				block[i][j - 1] = block[i][j];
				block[i][j] = 0;
			}
	}

	private int getLeftBorder() {
		// FIXME temp variables
		int i = 0, j = 0;
		int tmp1 = 3;
		int tmp2 = 3;

		for (j = 0; j < block.length; j++) {
			for (i = 0; i < block[j].length; i++) {
				if (block[j][i] >= 1) {
					tmp1 = i;
					break;
				}
			}
			if (tmp1 < tmp2)
				tmp2 = tmp1;
			tmp1 = 3;
		}

		return tmp2;
	}

	private int getRightBorder() {
		// FIXME temp variables
		int tmp1 = 0;
		int tmp2 = 0;

		for (int j = 0; j < block.length; j++) {
			for (int i = 0; i < block[j].length; i++) {
				if (block[j][i] >= 1)
					tmp1 = i + 1;
			}
			if (tmp1 > tmp2)
				tmp2 = tmp1;
			tmp1 = 0;
		}

		return tmp2;
	}

	private int getDownBorder() {
		// FIXME temp variables
		int tmp1 = 0;
		int tmp2 = 0;

		for (int j = 0; j < block.length; j++) {
			for (int i = 0; i < block[j].length; i++) {
				if (block[i][j] >= 1)
					tmp1 = i + 1;
			}
			if (tmp1 > tmp2)
				tmp2 = tmp1;
			tmp1 = 0;
		}

		return tmp2;
	}
}
