/**
 * @author Bastien Aracil
 **/
module fpc.aoc.input {
  requires static lombok;
  requires transitive fpc.aoc.api;
  requires transitive fpc.aoc.common;
  requires java.net.http;

  exports fpc.aoc.input;
}
