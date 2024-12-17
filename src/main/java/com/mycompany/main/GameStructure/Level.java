package com.mycompany.main.GameStructure;

import java.util.ArrayList;
import java.util.List;

public class Level {

        int levelNo;
        public char[][] board;
        public List<Position> coloredSqures;
        public List<Position> goalSquares;
        public static final List<Level> levels = new ArrayList<>();

        public Level() {
        }

        public Level(int levelNo, char[][] board, List<Position> coloredSquares, List<Position> goalSquares) {
                this.levelNo = levelNo;
                this.board = board;
                this.coloredSqures = coloredSquares;
                this.goalSquares = goalSquares;
        }

        static {
                // Level 1 setup
                char[][] boardLevel1 = {
                                { '#', '#', '#', '#', '#', '#', '#', '#' },
                                { '#', 'R', ' ', ' ', ' ', ' ', 'r', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#' }
                };
                List<Position> coloredSquaresLevel1 = new ArrayList<>();
                coloredSquaresLevel1.add(new Position(1, 1, 'R'));
                List<Position> goalSquaresLevel1 = new ArrayList<>();
                goalSquaresLevel1.add(new Position(1, 6, 'r'));
                levels.add(new Level(1, boardLevel1, coloredSquaresLevel1, goalSquaresLevel1));
                // level 2 setup
                char[][] boardLevel2 = { { '#', '#', '#', '#', '#', '#', '#', '#' },
                                { '#', ' ', ' ', '#', ' ', ' ', ' ', '#' },
                                { '#', 'O', ' ', ' ', ' ', ' ', ' ', '#' },
                                { '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                                { '#', '#', '#', '#', 'o', '#', '#', '#' },
                                { ' ', ' ', ' ', '#', '#', '#', ' ', ' ' } };
                List<Position> coloredSquaresLevel2 = new ArrayList<>();
                coloredSquaresLevel2.add(new Position(2, 1, 'O'));
                List<Position> goalSquaresLevel2 = new ArrayList<>();
                goalSquaresLevel2.add(new Position(4, 4, 'o'));
                levels.add(new Level(2, boardLevel2, coloredSquaresLevel2, goalSquaresLevel2));
                // level 3 setup
                char[][] boardLevel3 = { { ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
                                { ' ', ' ', '#', 'O', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                                { '#', '#', '#', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#' },
                                { '#', ' ', ' ', ' ', ' ', ' ', 'o', ' ', ' ', ' ', '#', ' ', '#' },
                                { '#', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#' },
                                { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                                { '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                                { ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };

                List<Position> coloredSquaresLevel3 = new ArrayList<>();
                coloredSquaresLevel3.add(new Position(1, 3, 'O'));
                List<Position> goalSquaresLevel3 = new ArrayList<>();
                goalSquaresLevel3.add(new Position(3, 6, 'o'));
                levels.add(new Level(3, boardLevel3, coloredSquaresLevel3, goalSquaresLevel3));
                // level 6 setup
                char[][] boardLevel6 = { { '#', '#', '#', '#', '#', '#', ' ', ' ', ' ' },
                                { '#', 'o', ' ', ' ', ' ', '#', '#', ' ', ' ' },
                                { '#', ' ', ' ', 'b', ' ', ' ', '#', '#', '#' },
                                { '#', ' ', ' ', ' ', ' ', ' ', 'B', 'O', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
                List<Position> coloredSquaresLevel6 = new ArrayList<>();
                coloredSquaresLevel6.add(new Position(3, 6, 'B'));
                coloredSquaresLevel6.add(new Position(3, 7, 'O'));
                List<Position> goalSquaresLevel6 = new ArrayList<>();
                goalSquaresLevel6.add(new Position(1, 1, 'o'));
                goalSquaresLevel6.add(new Position(2, 3, 'b'));

                levels.add(new Level(6, boardLevel6, coloredSquaresLevel6, goalSquaresLevel6));
                // level 9 setup
                char[][] boardLevel9 = {
                                { ' ', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ' },
                                { '#', '#', 'R', ' ', ' ', '#', '#', '#', '#', '#', ' ' },
                                { '#', ' ', ' ', ' ', ' ', '#', '#', 'b', ' ', '#', ' ' },
                                { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#' },
                                { '#', ' ', ' ', ' ', '#', '#', '#', ' ', ' ', 'r', '#' },
                                { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#' },
                                { '#', '#', 'B', ' ', '#', '#', '#', '#', '#', '#', ' ' },
                                { ' ', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ' },
                };
                List<Position> coloredSquaresLevel9 = new ArrayList<>();
                coloredSquaresLevel9.add(new Position(1, 2, 'R'));
                coloredSquaresLevel9.add(new Position(6, 2, 'B'));
                List<Position> goalSquaresLevel9 = new ArrayList<>();
                goalSquaresLevel9.add(new Position(4, 9, 'r'));
                goalSquaresLevel9.add(new Position(2, 7, 'b'));

                levels.add(new Level(9, boardLevel9, coloredSquaresLevel9, goalSquaresLevel9));

                // level 10 setup
                char[][] boardLevel10 = {
                                { ' ', ' ', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ' },
                                { ' ', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', ' ' },
                                { '#', '#', ' ', ' ', '#', ' ', 'b', '#', ' ', ' ', '#', '#' },
                                { '#', ' ', ' ', '#', ' ', 'r', ' ', ' ', '#', ' ', ' ', '#' },
                                { '#', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#', '#', ' ', '#' },
                                { '#', 'R', '#', ' ', '#', '#', ' ', ' ', ' ', '#', 'B', '#' },
                                { '#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' } };
                List<Position> coloredSquaresLevel10 = new ArrayList<>();
                coloredSquaresLevel10.add(new Position(5, 10, 'B'));
                coloredSquaresLevel10.add(new Position(5, 1, 'R'));
                List<Position> goalSquaresLevel10 = new ArrayList<>();
                goalSquaresLevel10.add(new Position(2, 6, 'b'));
                goalSquaresLevel10.add(new Position(3, 5, 'r'));

                levels.add(new Level(10, boardLevel10, coloredSquaresLevel10, goalSquaresLevel10));

                // level 11 setup
                char[][] boardLevel11 = { { ' ', '#', '#', '#', ' ', ' ', ' ', ' ' },
                                { '#', '#', 'y', '#', '#', '#', '#', '#' },
                                { '#', 'Y', 'R', 'B', ' ', ' ', ' ', '#' },
                                { '#', 'b', '#', 'r', '#', '#', '#', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#' } };
                List<Position> coloredSquaresLevel11 = new ArrayList<>();
                coloredSquaresLevel11.add(new Position(2, 1, 'Y'));
                coloredSquaresLevel11.add(new Position(2, 2, 'R'));
                coloredSquaresLevel11.add(new Position(2, 3, 'B'));
                List<Position> goalSquaresLevel11 = new ArrayList<>();
                goalSquaresLevel11.add(new Position(1, 2, 'y'));
                goalSquaresLevel11.add(new Position(3, 3, 'r'));
                goalSquaresLevel11.add(new Position(3, 1, 'b'));

                levels.add(new Level(11, boardLevel11, coloredSquaresLevel11, goalSquaresLevel11));

                // level 20 setup
                char[][] boardLevel20 = {
                                { ' ', ' ', ' ', '#', '#', '#', '#', ' ', ' ' },
                                { '#', '#', '#', '#', 'R', 'y', '#', '#', '#' },
                                { '#', 'b', 'P', 'B', ' ', ' ', ' ', ' ', '#' },
                                { '#', ' ', 'G', '#', 'r', ' ', '#', 'Y', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#' },
                };
                List<Position> coloredSquaresLevel20 = new ArrayList<>();
                coloredSquaresLevel20.add(new Position(1, 4, 'R'));
                coloredSquaresLevel20.add(new Position(2, 2, 'P'));
                coloredSquaresLevel20.add(new Position(2, 3, 'B'));
                coloredSquaresLevel20.add(new Position(3, 2, 'G'));
                coloredSquaresLevel20.add(new Position(3, 7, 'Y'));
                List<Position> goalSquaresLevel20 = new ArrayList<>();
                goalSquaresLevel20.add(new Position(1, 5, 'y'));
                goalSquaresLevel20.add(new Position(2, 1, 'b'));
                goalSquaresLevel20.add(new Position(3, 2, 'p'));
                goalSquaresLevel20.add(new Position(3, 4, 'r'));
                goalSquaresLevel20.add(new Position(3, 7, 'g'));

                levels.add(new Level(20, boardLevel20, coloredSquaresLevel20, goalSquaresLevel20));

                // level 21 setup
                char[][] boardLevel21 = {
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
                                { '#', 'R', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
                                { '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#' },
                                { '#', ' ', '#', '#', '#', '#', '#', '#', ' ', '#' },
                                { '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'r', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }
                };
                List<Position> coloredSquaresLevel21 = new ArrayList<>();
                coloredSquaresLevel21.add(new Position(1, 1, 'R'));
                List<Position> goalSquaresLevel21 = new ArrayList<>();
                goalSquaresLevel21.add(new Position(4, 8, 'r'));

                levels.add(new Level(21, boardLevel21, coloredSquaresLevel21, goalSquaresLevel21));

                // level 26 setup
                char[][] boardLevel26 = {
                                { ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', '#', '#', '#' },
                                { '#', '#', '#', '#', '#', ' ', ' ', '#', '#', ' ', 'p', '#' },
                                { '#', 'w', 'b', 'y', '#', '#', '#', '#', ' ', ' ', ' ', '#' },
                                { '#', ' ', ' ', ' ', 'B', 'P', 'Y', 'R', ' ', ' ', ' ', '#' },
                                { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' }

                };
                List<Position> coloredSquaresLevel26 = new ArrayList<>();
                coloredSquaresLevel26.add(new Position(3, 6, 'B'));
                coloredSquaresLevel26.add(new Position(3, 4, 'Y'));
                coloredSquaresLevel26.add(new Position(3, 5, 'P'));
                coloredSquaresLevel26.add(new Position(3, 7, 'R'));
                List<Position> goalSquaresLevel26 = new ArrayList<>();
                // goalSquaresLevel26.add(new Position(2, 1, 'w'));
                goalSquaresLevel26.add(new Position(2, 2, 'b'));
                goalSquaresLevel26.add(new Position(2, 3, 'y'));
                goalSquaresLevel26.add(new Position(1, 10, 'p'));

                levels.add(new Level(26, boardLevel26, coloredSquaresLevel26, goalSquaresLevel26));

                char[][] boardLevel30 = {
                                { ' ', ' ', ' ', '#', '#', '#', '#', '#', '#', ' ', '#', '#', '#', '#', '#', '#' },
                                { '#', '#', '#', '#', '#', ' ', ' ', 'p', '#', '#', '#', 'y', '#', '#', 'g', '#' },
                                { '#', 'R', 'B', 'G', ' ', ' ', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#' },
                                { '#', 'Y', 'P', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', ' ', '#' },
                                { '#', '#', '#', '#', '#', 'w', '#', '#', 'b', '#', '#', '#', '#', '#', '#', '#' },
                                { ' ', ' ', ' ', ' ', '#', '#', '#', '#', 'X', '#', ' ', ' ', ' ', ' ', ' ', ' ' },
                };
                List<Position> coloredSquaresLevel30 = new ArrayList<>();
                coloredSquaresLevel30.add(new Position(3, 2, 'P'));
                coloredSquaresLevel30.add(new Position(3, 1, 'Y'));
                coloredSquaresLevel30.add(new Position(2, 3, 'G'));
                coloredSquaresLevel30.add(new Position(2, 2, 'B'));
                coloredSquaresLevel30.add(new Position(2, 1, 'R'));
                List<Position> goalSquaresLevel30 = new ArrayList<>();
                goalSquaresLevel30.add(new Position(1, 7, 'p'));
                goalSquaresLevel30.add(new Position(1, 11, 'y'));
                goalSquaresLevel30.add(new Position(1, 14, 'g'));
                // goalSquaresLevel30.add(new Position(4, 5, 'w'));
                goalSquaresLevel30.add(new Position(4, 8, 'b'));

                levels.add(new Level(30, boardLevel30, coloredSquaresLevel30, goalSquaresLevel30));

        }

        public Level getCurrentLevel(int levelNo) {
                for (Level level : levels) {
                        if (level.levelNo == levelNo) {
                                return level;
                        }
                }
                return null;
        }

}
