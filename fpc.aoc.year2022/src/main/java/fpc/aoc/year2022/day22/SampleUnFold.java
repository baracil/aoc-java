package fpc.aoc.year2022.day22;

import fpc.aoc.common.Position;

public class SampleUnFold implements UnFold {

  private final int width = 50;

  @Override
  public Move findNext(Position position, Orientation orientation) {
    final var quadrant = 10*(position.x()/width)+(position.y()/width);
    return switch (orientation) {
      case RIGHT -> findRight(position,quadrant);
      case LEFT -> findLeft(position,quadrant);
      case UP -> findUp(position,quadrant);
      case DOWN -> findDown(position,quadrant);
    };
  }

  private Move findRight(Position position,int quadrant) {
    if ((position.x()+1)%width != 0) {
      return Move.displaced(position,Orientation.RIGHT);
    }
    final var my = position.y()%width;
    return switch (quadrant) {
      case 20 -> new Move(width*2-1,width*3-1-my,Orientation.LEFT);
      case 11 -> new Move(width*2+my,width-1, Orientation.UP);
      case 12 -> new Move(width*3-1,width-1-my,Orientation.LEFT);
      case 3  -> new Move(width+my,3*width-1,Orientation.UP);
      default ->  Move.displaced(position,Orientation.RIGHT);
    };
  }

  private Move findLeft(Position position, int quadrant) {
    if (position.x()%width != 0) {
      return Move.displaced(position,Orientation.LEFT);
    }
    final var my = position.y()%width;
    return switch (quadrant) {
      case 10 -> new Move(0,width*3-1-my,Orientation.RIGHT);
      case 11 -> new Move(my,width*2,Orientation.DOWN);
      case 2 -> new Move(width,width-1-my,Orientation.RIGHT);
      case 3 -> new Move(width+my,0,Orientation.DOWN);
      default ->  Move.displaced(position,Orientation.LEFT);
    };
  }

  private Move findUp(Position position,int quadrant) {
    if (position.y()%width != 0) {
      return Move.displaced(position,Orientation.UP);
    }
    final var mx = position.x()%width;
    return switch (quadrant) {
      case 10 -> new Move(0,width*3+mx,Orientation.RIGHT);
      case 20 -> new Move(mx,width*4-1,Orientation.UP);
      case 2 -> new Move(width,width+mx,Orientation.RIGHT);
      default ->  Move.displaced(position,Orientation.UP);
    };
  }

  private Move findDown(Position position, int quadrant) {
    if ((position.y()+1)%width != 0) {
      return Move.displaced(position,Orientation.DOWN);
    }
    final var mx = position.x()%width;
    return switch (quadrant) {
      case 20 -> new Move(2*width-1,width+mx,Orientation.LEFT);
      case 12 -> new Move(width-1,3*width+mx,Orientation.LEFT);
      case 3 -> new Move(2*width+mx, 0, Orientation.DOWN);
      default ->  Move.displaced(position,Orientation.DOWN);
    };
  }
}
