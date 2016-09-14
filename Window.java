import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.List;

public class Window {
	public static class Grid extends JPanel implements KeyListener{
		int xPos = 20;
		int yPos = 60;
		private List<Point> fillCells;
		private List<Point> shipCells;
		JLabel gap = new JLabel("Select a square with space\n");
		JLabel label = new JLabel("Use the arrows to move");
		boolean ship1 = false;
		boolean ship2 = false;
		boolean ship3 = false;
		boolean ship4 = false;
		boolean ship5 = false;
		boolean ship6 = false;
		boolean ship7 = false;
		boolean placeSmall = false;
		boolean placeMid = false;
		boolean placeLarge = false;
		boolean placeHuge = false;
		boolean smallP = false;
		boolean midPL = false;
		boolean midPR = false;
		boolean midPU = false;
		boolean midPD = false;
		boolean largePR = false;
		boolean largePL = false;
		boolean largePU = false;
		boolean largePD = false;
		boolean hugePR = false;
		boolean hugePL = false;
		boolean hugePU = false;
		boolean hugePD = false;
		int ship1X1 = 0;
		int ship1Y1 = 0;
		int ship2X1 = 0;
		int ship2Y1 = 0;
		int ship3X1 = 0;
		int ship3Y1 = 0;
		int ship4X1 = 0;
		int ship4Y1 = 0;
		int ship5X1 = 0;
		int ship5Y1 = 0;
		int ship6X1 = 0;
		int ship6Y1 = 0;
		int ship1X2 = 0;
		int ship1Y2 = 0;
		int ship2X2 = 0;
		int ship2Y2 = 0;
		int ship3X2 = 0;
		int ship3Y2 = 0;
		int ship4X2 = 0;
		int ship4Y2 = 0;
		int ship5X2 = 0;
		int ship5Y2 = 0;
		int ship6X2 = 0;
		int ship6Y2 = 0;
		int ship3X3 = 0;
		int ship3Y3 = 0;
		int ship4X3 = 0;
		int ship4Y3 = 0;
		int ship5X3 = 0;
		int ship5Y3 = 0;
		int ship6X3 = 0;
		int ship6Y3 = 0;
		int ship6X4 = 0;
		int ship6Y4 = 0;
		int ship7Y1 = 0;
		int ship7X1 = 0;
		int ship7Y2 = 0;
		int ship7X2 = 0;
		int ship7Y3 = 0;
		int ship7X3 = 0;
		int ship7X4 = 0;
		int ship7Y4 = 0;
		int ship7X5 = 0;
		int ship7Y5 = 0;
		
		public Grid() {
			fillCells = new ArrayList<>(25);
			shipCells = new ArrayList<>(25);
			addKeyListener(this);
			setFocusable(true);
			requestFocusInWindow();
			
			//Sort out some text
			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Font font = new Font("Comic Sans", Font.BOLD, 16);
			label.setFont(font);
			label.setAlignmentX(Component.CENTER_ALIGNMENT);
			gap.setAlignmentX(Component.CENTER_ALIGNMENT);
			add(gap);
			add(label);
		}
		
		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            //Draw the grid
           	for (Point fillCell : fillCells) {
           		int cellX = 20 + (fillCell.x * 40);
           		int cellY = 60 + (fillCell.y * 40);
           		g.setColor(Color.decode("#0077FF"));
           		g.fillRect(cellX, cellY, 40, 40);
           	}
           	for (Point shipCell : shipCells) {
           		int X = shipCell.x;
           		int Y = shipCell.y;
           		g.setColor(Color.GRAY);
           		g.fillRect(X, Y, 40, 40);
           	}
            g.setColor(Color.WHITE);
           	g.drawRect(20, 60, 480, 480);
           	for (int i = 20; i <= 540; i += 40) {
           		g.drawLine(i, 60, i, 540);
            }
           	for (int i = 60; i <= 500; i += 40) {
           		g.drawLine(20, i, 500, i);
           	}
            g.setColor(Color.BLACK);
            g.drawRect(xPos, yPos, 40, 40);
            
            
            
        }
            
		public void fillCell(int x, int y) {
			fillCells.add(new Point(x, y));
			repaint();
		}
		
		public void shipCell(int x, int y) {
			shipCells.add(new Point(x, y));
			repaint();
		}
		
		public void keyTyped(KeyEvent e) {
			if (placeSmall) {
				rotateS(e);
			}
			else if (placeMid) {
				rotateM(e);
			}
			else if (placeLarge) {
				rotateL(e);
			}
			else if (placeHuge) {
				rotateH(e);
			}
			else {
				move(e);
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (placeSmall) {
				rotateS(e);
			}
			else if (placeMid) {
				rotateM(e);
			}
			else if (placeLarge) {
				rotateL(e);
			}
			else if (placeHuge) {
				rotateH(e);
			}
			else {
				move(e);
			}
		}
		
		//Cursor movement
		public void move(KeyEvent k) {
			if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (xPos < 440) {
					xPos = xPos + 40;
					repaint();
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_LEFT) {
				if (xPos > 20) {
					xPos = xPos - 40;
					repaint();
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_DOWN) {
				if (yPos < 480) {
					yPos = yPos + 40;
					repaint();
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_UP) {
				if (yPos > 60) {
					yPos = yPos - 40;
					repaint();
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_SPACE) {
				if (!ship1) {
					shipCell(xPos, yPos);
					ship1X1 = xPos;
					ship1Y1 = yPos;
					ship1 = true;
					placeSmall = true;
				}
				else if (!ship2) {
					if ((xPos == ship1X1 && yPos == ship1Y1) || (xPos == ship1X2 && yPos == ship1Y2)) {
						gap.setText("It can't go there");
					}
					else {
						shipCell(xPos, yPos);
						ship2 = true;
						ship2X1 = xPos;
						ship2Y1 = yPos;
						placeSmall = true;
					}
				}
				else if (!ship3) {
					if ((xPos == ship1X1 && yPos == ship1Y1) || (xPos == ship2X1 && yPos == ship2Y1) || (xPos == ship2X2 && yPos == ship2Y2) || (xPos == ship1X2 && yPos == ship1Y2)) {
						gap.setText("It can't go there");
					}
					else {
						shipCell(xPos, yPos);
						ship3 = true;
						ship3X1 = xPos;
						ship3Y1 = yPos;
						placeMid = true;
					}
				}
				else if (!ship4) {
					if ((xPos == ship1X1 && yPos == ship1Y1) || (xPos == ship2X1 && yPos == ship2Y1) || (xPos == ship3X1 && yPos == ship3Y1) || (xPos == ship2X2 && yPos == ship2Y2) || (xPos == ship1X2 && yPos == ship1Y2) || (xPos == ship3X2 && yPos == ship3Y2) || (xPos == ship3X3 && yPos == ship3Y3)) {
						gap.setText("It can't go there");
					}
					else {
						shipCell(xPos, yPos);
						ship4 = true;
						ship4X1 = xPos;
						ship4Y1 = yPos;
						placeMid = true;
					}
				}
				else if (!ship5) {
					if ((xPos == ship1X1 && yPos == ship1Y1) || (xPos == ship2X1 && yPos == ship2Y1) || (xPos == ship3X1 && yPos == ship3Y1) || (xPos == ship4X1 && yPos == ship4Y1) || (xPos == ship2X2 && yPos == ship2Y2) || (xPos == ship1X2 && yPos == ship1Y2) || (xPos == ship3X2 && yPos == ship3Y2) || (xPos == ship3X3 && yPos == ship3Y3) || (xPos == ship4X2 && yPos == ship4Y2) || (xPos == ship4X3 && yPos == ship4Y3)) {
						gap.setText("It can't go there");
					}
					else {
						shipCell(xPos, yPos);
						ship5 = true;
						ship5X1 = xPos;
						ship5Y1 = yPos;
						placeMid = true;
					}
				}
				else if (!ship6) {
					if ((xPos == ship1X1 && yPos == ship1Y1) || (xPos == ship2X1 && yPos == ship2Y1) || (xPos == ship3X1 && yPos == ship3Y1) || (xPos == ship4X1 && yPos == ship4Y1) || (xPos == ship5X1 && yPos == ship5Y1) || (xPos == ship2X2 && yPos == ship2Y2) || (xPos == ship1X2 && yPos == ship1Y2) || (xPos == ship3X2 && yPos == ship3Y2) || (xPos == ship3X3 && yPos == ship3Y3) || (xPos == ship4X2 && yPos == ship4Y2) || (xPos == ship4X3 && yPos == ship4Y3) || (xPos == ship5X2 && yPos == ship5Y2) || (xPos == ship5X3 && yPos == ship5Y3)) {
						gap.setText("It can't go there");
					}
					else {
						shipCell(xPos, yPos);
						ship6 = true;
						ship6X1 = xPos;
						ship6Y1 = yPos;
						placeLarge = true;
					}
				}
				else if (!ship7) {
					if ((xPos == ship1X1 && yPos == ship1Y1) || (xPos == ship2X1 && yPos == ship2Y1) || (xPos == ship3X1 && yPos == ship3Y1) || (xPos == ship4X1 && yPos == ship4Y1) || (xPos == ship5X1 && yPos == ship5Y1) || (xPos == ship6X1 && yPos == ship6Y1) || (xPos == ship2X2 && yPos == ship2Y2) || (xPos == ship1X2 && yPos == ship1Y2) || (xPos == ship3X2 && yPos == ship3Y2) || (xPos == ship3X3 && yPos == ship3Y3) || (xPos == ship4X2 && yPos == ship4Y2) || (xPos == ship4X3 && yPos == ship4Y3) || (xPos == ship5X2 && yPos == ship5Y2) || (xPos == ship5X3 && yPos == ship5Y3) || (xPos == ship6X3 && yPos == ship6Y3) || (xPos == ship6X2 && yPos == ship6Y2) || (xPos == ship6X4 && yPos == ship6Y4)) {
						gap.setText("It can't go there");
					}
					else {
						shipCell(xPos, yPos);
						ship7 = true;
						ship7X1 = xPos;
						ship7Y1 = yPos;
						placeHuge = true;
					}
				}
			}
		}
		
		//Small ship orientation
		public void rotateS(KeyEvent k) {
			if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
				if ((xPos + 40 == ship1X1 && yPos == ship1Y1) || (xPos + 40 == ship1X2 && yPos == ship1Y2)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos + 40, yPos);
					if (!ship2) {
						ship1X2 = xPos + 40;
						ship1Y2 = yPos;
					}
					else {
						ship2X2 = xPos + 40;
						ship2Y2 = yPos;
					}
					gap.setText("Space to confirm");
					smallP = true;
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_LEFT) {
				if ((xPos - 40 == ship1X1 && yPos == ship1Y1) || (xPos - 40 == ship1X2 && yPos == ship1Y2)) {
					gap.setText("Nope");
					smallP = false;
				}
				else{
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos - 40, yPos);
					if (!ship2) {
						ship1X2 = xPos - 40;
						ship1Y2 = yPos;
					}
					else {
						ship2X2 = xPos - 40;
						ship2Y2 = yPos;
					}
					gap.setText("Space to confirm");
					smallP = true;
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_UP) {
				if ((xPos == ship1X1 && yPos - 40 == ship1Y1) || (xPos == ship1X2 && yPos - 40 == ship1Y2)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos, yPos - 40);
					if (!ship2) {
						ship1X2 = xPos;
						ship1Y2 = yPos - 40;
					}
					else {
						ship2X2 = xPos;
						ship2Y2 = yPos - 40;
					}
					gap.setText("Space to confirm");
					smallP = true;
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_DOWN) {
				if ((xPos == ship1X1 && yPos + 40 == ship1Y1) || (xPos == ship1X2 && yPos + 40 == ship1Y2)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos, yPos + 40);
					if (!ship2) {
						ship1X2 = xPos;
						ship1Y2 = yPos + 40;
					}
					else {
						ship2X2 = xPos;
						ship2Y2 = yPos + 40;
					}
					gap.setText("Space to confirm");
					smallP = true;
				}
			}
			if (smallP) {
				if (k.getKeyCode() == KeyEvent.VK_SPACE) {
					shipCell(xPos, yPos);
					placeSmall = false;
					gap.setText("Select a new square");
				}
			}
		}
		
		//Medium ship orientation
		public void rotateM(KeyEvent k) {
			if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
				if ((xPos + 40 == ship1X1 && yPos == ship1Y1) || (xPos + 40 == ship1X2 && yPos == ship1Y2) || (xPos + 40 == ship2X1 && yPos == ship2Y1) || (xPos + 40 == ship2X2 && yPos == ship2Y2) || (xPos + 80 == ship1X1 && yPos == ship1Y1) || (xPos + 80 == ship1X2 && yPos == ship1Y2) || (xPos + 80 == ship2X1 && yPos == ship2Y1) || (xPos + 80 == ship2X2 && yPos == ship2Y2) || (xPos + 40 == ship3X1 && yPos == ship3Y1) || (xPos + 40 == ship3X2 && yPos == ship3Y2) || (xPos + 40 == ship3X3 && yPos == ship3Y3) || (xPos + 80 == ship3X1 && yPos == ship3Y1) || (xPos + 80 == ship3X2 && yPos == ship3Y2) || (xPos + 80 == ship3X3 && yPos == ship3Y3) || (xPos + 40 == ship4X1 && yPos == ship4Y1) || (xPos + 40 == ship4X2 && yPos == ship4Y2) || (xPos + 40 == ship4X3 && yPos == ship4Y3) || (xPos + 80 == ship4X1 && yPos == ship4Y1) || (xPos + 80 == ship4X2 && yPos == ship4Y2) || (xPos + 80 == ship4X3 && yPos == ship4Y3)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos + 80, yPos);
					midPR = true;
					midPL = midPU = midPD = false;
					gap.setText("Space to confirm");
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_LEFT) {
				if ((xPos - 40 == ship1X1 && yPos == ship1Y1) || (xPos - 40 == ship1X2 && yPos == ship1Y2) || (xPos - 40 == ship2X1 && yPos == ship2Y1) || (xPos - 40 == ship2X2 && yPos == ship2Y2) || (xPos - 80 == ship1X1 && yPos == ship1Y1) || (xPos - 80 == ship1X2 && yPos == ship1Y2) || (xPos - 80 == ship2X1 && yPos == ship2Y1) || (xPos - 80 == ship2X2 && yPos == ship2Y2) || (xPos - 40 == ship3X1 && yPos == ship3Y1) || (xPos - 40 == ship3X2 && yPos == ship3Y2) || (xPos - 40 == ship3X3 && yPos == ship3Y3) || (xPos - 80 == ship3X1 && yPos == ship3Y1) || (xPos - 80 == ship3X2 && yPos == ship3Y2) || (xPos - 80 == ship3X3 && yPos == ship3Y3) || (xPos - 40 == ship4X1 && yPos == ship4Y1) || (xPos - 40 == ship4X2 && yPos == ship4Y2) || (xPos - 40 == ship4X3 && yPos == ship4Y3) || (xPos - 80 == ship4X1 && yPos == ship4Y1) || (xPos - 80 == ship4X2 && yPos == ship4Y2) || (xPos - 80 == ship4X3 && yPos == ship4Y3)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos - 80, yPos);
					midPL = true;
					midPR = midPU = midPD = false;
					gap.setText("Space to confirm");
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_UP) {
				if ((xPos == ship1X1 && yPos - 40 == ship1Y1) || (xPos == ship1X2 && yPos - 40 == ship1Y2) || (xPos == ship2X1 && yPos - 40 == ship2Y1) || (xPos == ship2X2 && yPos - 40 == ship2Y2) || (xPos == ship1X1 && yPos - 80 == ship1Y1) || (xPos == ship1X2 && yPos - 80 == ship1Y2) || (xPos == ship2X1 && yPos - 80 == ship2Y1) || (xPos == ship2X2 && yPos - 80 == ship2Y2) || (xPos == ship3X1 && yPos - 40 == ship3Y1) || (xPos == ship3X2 && yPos - 40 == ship3Y2) || (xPos == ship3X3 && yPos - 40 == ship3Y3) || (xPos == ship3X1 && yPos - 80 == ship3Y1) || (xPos == ship3X2 && yPos - 80 == ship3Y2) || (xPos == ship3X3 && yPos - 80 == ship3Y3) || (xPos == ship4X1 && yPos - 40 == ship4Y1) || (xPos == ship4X2 && yPos - 40 == ship4Y2) || (xPos == ship4X3 && yPos - 40 == ship4Y3) || (xPos == ship4X1 && yPos - 80 == ship4Y1) || (xPos == ship4X2 && yPos - 80 == ship4Y2) || (xPos == ship4X3 && yPos - 80 == ship4Y3)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos, yPos - 80);
					midPU = true;
					midPL = midPR = midPD = false;
					gap.setText("Space to confirm");
				}
			}
			if (k.getKeyCode() == KeyEvent.VK_DOWN) {
				if ((xPos == ship1X1 && yPos + 40 == ship1Y1) || (xPos == ship1X2 && yPos + 40 == ship1Y2) || (xPos == ship2X1 && yPos + 40 == ship2Y1) || (xPos == ship2X2 && yPos + 40 == ship2Y2) || (xPos == ship1X1 && yPos + 80 == ship1Y1) || (xPos == ship1X2 && yPos + 80 == ship1Y2) || (xPos == ship2X1 && yPos + 80 == ship2Y1) || (xPos == ship2X2 && yPos + 80 == ship2Y2) || (xPos == ship3X1 && yPos + 40 == ship3Y1) || (xPos == ship3X2 && yPos + 40 == ship3Y2) || (xPos == ship3X3 && yPos + 40 == ship3Y3) || (xPos == ship3X1 && yPos + 80 == ship3Y1) || (xPos == ship3X2 && yPos + 80 == ship3Y2) || (xPos == ship3X3 && yPos + 80 == ship3Y3) || (xPos == ship4X1 && yPos + 40 == ship4Y1) || (xPos == ship4X2 && yPos + 40 == ship4Y2) || (xPos == ship4X3 && yPos + 40 == ship4Y3) || (xPos == ship4X1 && yPos + 80 == ship4Y1) || (xPos == ship4X2 && yPos + 80 == ship4Y2) || (xPos == ship4X3 && yPos + 80 == ship4Y3)) {
					gap.setText("Nope");
					smallP = false;
				}
				else {
					shipCells.remove(shipCells.size() - 1);
					shipCell(xPos, yPos + 80);
					midPD = true;
					midPL = midPU = midPR = false;
					gap.setText("Space to confirm");
				}
			}
			if (midPL || midPR || midPU || midPD) {
				if (k.getKeyCode() == KeyEvent.VK_SPACE) {
					if (midPR) {
						shipCell(xPos, yPos);
						shipCell(xPos + 40, yPos);
						if (!ship4) {
							ship3X2 = xPos + 40;
							ship3X3 = xPos + 80;
							ship3Y2 = ship3Y3 = yPos;
						}
						else if (!ship5) {
							ship4X2 = xPos + 40;
							ship4X3 = xPos + 80;
							ship4Y2 = ship4Y3 = yPos;
						}
						else {
							ship5X2 = xPos + 40;
							ship5X3 = xPos + 80;
							ship5Y2 = ship5Y3 = yPos;
						}
						placeMid = false;
					}
					else if (midPL) {
						shipCell(xPos, yPos);
						shipCell(xPos - 40, yPos);
						if (!ship4) {
							ship3X2 = xPos - 40;
							ship3X3 = xPos - 80;
							ship3Y2 = ship3Y3 = yPos;
						}
						else if (!ship5) {
							ship4X2 = xPos - 40;
							ship4X3 = xPos - 80;
							ship4Y2 = ship4Y3 = yPos;
						}
						else {
							ship5X2 = xPos - 40;
							ship5X3 = xPos - 80;
							ship5Y2 = ship5Y3 = yPos;
						}
						placeMid = false;
					}
					else if (midPU) {
						shipCell(xPos, yPos);
						shipCell(xPos , yPos - 40);
						if (!ship4) {
							ship3X2 = ship3X3 = xPos;
							ship3Y2 = yPos - 40;
							ship3Y3 = yPos - 80;
						}
						else if (!ship5) {
							ship4X2 = ship4X3 = xPos;
							ship4Y2 = yPos - 40;
							ship4Y3 = yPos - 80;
						}
						else {
							ship5X2 = ship5X3 = xPos;
							ship5Y2 = yPos - 40;
							ship5Y3 = yPos - 80;
						}
						placeMid = false;
					}
					else if (midPD) {
						shipCell(xPos, yPos);
						shipCell(xPos , yPos + 40);
						if (!ship4) {
							ship3X2 = ship3X3 = xPos;
							ship3Y2 = yPos + 40;
							ship3Y3 = yPos + 80;
						}
						else if (!ship5) {
							ship4X2 = ship4X3 = xPos;
							ship4Y2 = yPos + 40;
							ship4Y3 = yPos + 80;
						}
						else {
							ship5X2 = ship5X3 = xPos;
							ship5Y2 = yPos + 40;
							ship5Y3 = yPos + 80;
						}
						placeMid = false;
					}
				}
			}
		}
		
		//Large ship orientation
		public void rotateL(KeyEvent k) {
			if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos + 120, yPos);
				largePR = true;
				largePL = largePU = largePD = false;
			}
			if (k.getKeyCode() == KeyEvent.VK_LEFT) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos - 120, yPos);
				largePL = true;
				largePR = largePU = largePD = false;
			}
			if (k.getKeyCode() == KeyEvent.VK_UP) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos, yPos - 120);
				largePU = true;
				largePL = largePR = largePD = false;
			}
			if (k.getKeyCode() == KeyEvent.VK_DOWN) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos, yPos + 120);
				largePD = true;
				largePL = largePU = largePR = false;
			}
			if (largePL || largePR || largePU || largePD) {
				if (k.getKeyCode() == KeyEvent.VK_SPACE) {
					if (largePR) {
						shipCell(xPos, yPos);
						shipCell(xPos + 40, yPos);
						shipCell(xPos + 80, yPos);
						ship6X2 = xPos + 40;
						ship6X3 = xPos + 80;
						ship6X4 = xPos + 120;
						ship6Y2 = ship6Y3 = ship6Y4 = yPos;
						placeLarge = false;
					}
					else if (largePL) {
						shipCell(xPos, yPos);
						shipCell(xPos - 40, yPos);
						shipCell(xPos - 80, yPos);
						ship6X2 = xPos - 40;
						ship6X3 = xPos - 80;
						ship6X4 = xPos - 120;
						ship6Y2 = ship6Y3 = ship6Y4 = yPos;
						placeLarge = false;
					}
					else if (largePU) {
						shipCell(xPos, yPos);
						shipCell(xPos, yPos - 40);
						shipCell(xPos, yPos - 80);
						ship6X2 = ship6X3 = ship6X4 = xPos;
						ship6Y2 = yPos - 40;
						ship6Y3 = yPos - 80;
						ship6Y4 = yPos - 120;
						placeLarge = false;
					}
					else if (largePD) {
						shipCell(xPos, yPos);
						shipCell(xPos, yPos + 40);
						shipCell(xPos, yPos + 80);
						ship6X2 = ship6X3 = ship6X4 = xPos;
						ship6Y2 = yPos + 40;
						ship6Y3 = yPos + 80;
						ship6Y4 = yPos + 120;
						placeLarge = false;
					}
				}
			}
		}
		
		//Huge ship orientation
		public void rotateH(KeyEvent k) {
			if (k.getKeyCode() == KeyEvent.VK_RIGHT) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos + 160, yPos);
				hugePR = true;
				hugePL = hugePU = hugePD = false;
			}
			if (k.getKeyCode() == KeyEvent.VK_LEFT) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos - 160, yPos);
				hugePL = true;
				hugePR = hugePU = hugePD = false;
			}
			if (k.getKeyCode() == KeyEvent.VK_UP) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos, yPos - 160);
				hugePU = true;
				hugePL = hugePR = hugePD = false;
			}
			if (k.getKeyCode() == KeyEvent.VK_DOWN) {
				shipCells.remove(shipCells.size() - 1);
				shipCell(xPos, yPos + 160);
				hugePD = true;
				hugePL = hugePU = hugePR = false;
			}
			if (hugePL || hugePR || hugePU || hugePD) {
				if (k.getKeyCode() == KeyEvent.VK_SPACE) {
					if (hugePR) {
						shipCell(xPos, yPos);
						shipCell(xPos + 40, yPos);
						shipCell(xPos + 80, yPos);
						shipCell(xPos + 120, yPos);
						ship7X2 = xPos + 40;
						ship7X3 = xPos + 80;
						ship7X4 = xPos + 120;
						ship7X5 = xPos + 160;
						ship7Y2 = ship7Y3 = ship7Y4 = ship7Y5 = yPos;
						placeHuge = false;
					}
					else if (hugePL) {
						shipCell(xPos, yPos);
						shipCell(xPos - 40, yPos);
						shipCell(xPos - 80, yPos);
						shipCell(xPos - 120, yPos);
						ship7X2 = xPos - 40;
						ship7X3 = xPos - 80;
						ship7X4 = xPos - 120;
						ship7X5 = xPos - 160;
						ship7Y2 = ship7Y3 = ship7Y4 = ship7Y5 = yPos;
						placeHuge = false;
					}
					else if (hugePU) {
						shipCell(xPos, yPos);
						shipCell(xPos, yPos - 40);
						shipCell(xPos, yPos - 80);
						shipCell(xPos, yPos - 120);
						placeHuge = false;
					}
					else if (hugePD) {
						shipCell(xPos, yPos);
						shipCell(xPos, yPos + 40);
						shipCell(xPos, yPos + 80);
						shipCell(xPos, yPos + 120);
						placeHuge = false;
					}
				}
			}
		}
	}
	public static void main(String[] a) {
		EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {                

                //Create the window
                JFrame window = new JFrame("Battleships");
                window.setSize(540, 600);
                Grid grid = new Grid();
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                window.add(grid);
                window.setVisible(true);
                for (int i = 0; i < 12; i++) {
                	for (int j = 0; j < 12; j++) {
                		grid.fillCell(i, j);
                	}
                }
            }
    	});
	}
}
