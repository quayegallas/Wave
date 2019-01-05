package subject;

import custom.cell.ItemCell;
import custom.event.GameOverEvent;
import custom.cell.OrdinaryCell;
import custom.event.OrdinaryEvent;
import custom.item.MagicStone;
import custom.role.Player;
import entity.*;

import java.util.Scanner;

public class Game {

    private static Wave wave = new Wave();
    private static Integer width = 5;
    private static Integer height = 5;
    private static Role player = new Player();

    public Game() {
        wave.setRole(player);
    }

    public void init() {
        wave = new Wave();
        wave.setHeight(width);
        wave.setWidth(height);
        Cell[][] cells = new Cell[width][height];
        Integer overX = (int) (Math.random() * width);
        Integer overY = (int) (Math.random() * height);
        Integer magicX = (int) (Math.random() * width);
        Integer magicY = (int) (Math.random() * height);
//        System.out.println(overX + "," + overY);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String content = "";
                Cell cell = new OrdinaryCell(i, j);
                if (i == magicX && j == magicY) {
                    cell = new ItemCell(i, j, new MagicStone());
                } else {
                    if (i == width - 1) {
                        content = "东边是一面墙";
                    } else if (i == 0) {
                        content = "西边是一面墙";
                    }
                    if (j == height - 1) {
                        content += "北边是一面墙";
                    } else if (j == 0) {
                        content += "南边是一面墙";
                    }
                }
                if (i == overX && j == overY) {
                    cell.setEvent(new GameOverEvent());
                } else {
                    cell.setEvent(content.isEmpty() ? new OrdinaryEvent() : new OrdinaryEvent(content));
                }
                cells[i][j] = cell;
            }
            wave.setCells(cells);
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入出生点");
        String[] birthPoint = scanner.next().split(",");
        player.setX(Integer.valueOf(birthPoint[0]));
        player.setY(Integer.valueOf(birthPoint[1]));
        do {
            if (game.checkPlayer()) {
                return;
            }
            System.out.println("输入你的指令");
            String instructions = scanner.next();
            switch (instructions) {
                case "up":
                    player.setY(player.getY() + 1);
                    break;
                case "down":
                    player.setY(player.getY() - 1);
                    break;
                case "left":
                    player.setX(player.getX() - 1);
                    break;
                case "right":
                    player.setX(player.getX() + 1);
                    break;
                case "pickup":
                    takeItem();
                    break;
                case "item":
                    showItem();
                    break;
                default:
                    System.out.println("重新输入");
            }
        } while (true);
    }

    private static void showItem() {
        if (player.getItem() == null) {
            System.out.println("你当前没有任何物品");
            return;
        }
        System.out.println("你装备了" + player.getItem().getName());
    }

    private static void takeItem() {
        Cell cell = wave.getCells()[player.getX()][player.getY()];
        if (cell instanceof ItemCell) {
            Item item = ((ItemCell) cell).getItem();
            player.setItem(item);
            wave.getCells()[player.getX()][player.getY()] = new OrdinaryCell(player.getX(), player.getY(), cell.getEvent());
            System.out.println("你获得了" + item.getName());
        } else {
            System.out.println("这里似乎什么都没有");
        }
    }

    private boolean checkPlayer() {
        try {
            Cell cell = wave.getCells()[player.getX()][player.getY()];
            Event event = cell.getEvent();
            System.out.println(cell.getContent() + event.getContent());
            if (10 == event.getLevel()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("撞墙");
            if (player.getY() >= height) {
                player.setY(player.getY() - 1);
            } else if (player.getY() < 0) {
                player.setY(0);
            }
            if (player.getX() >= width) {
                player.setX(player.getX() - 1);
            } else if (player.getX() < 0) {
                player.setX(0);
            }
        }
//        showPlayer();
        return false;
    }

    private static void showPlayer() {
        System.out.println(player.getX() + "," + player.getY());
    }
}