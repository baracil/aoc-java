package fpc.aoc.year2022.day22;

public sealed interface Order permits Order.Move,Order.RotateR,Order.RotateL {

    Player apply(Player player, Map map);

    record Move(int nbSteps) implements Order {
        @Override
        public Player apply(Player player, Map map) {
            return player.move(map,nbSteps);
        }
    }

    record RotateR() implements Order{
        @Override
        public Player apply(Player player, Map map) {
            return player.rotateR();
        }
    }

    record RotateL() implements Order{
        @Override
        public Player apply(Player player, Map map) {
            return player.rotateL();
        }
    }
}
