package fpc.aoc.day19.model;

import java.util.function.Predicate;

public sealed interface ScrapPredicate extends Predicate<Scrap> {

  Split<MultiScrap> test(MultiScrap scrap);

  record LowerTest(ScrapProp prop, int value) implements ScrapPredicate {

    @Override
    public boolean test(Scrap scrap) {
      return prop.applyAsInt(scrap) < value;
    }


    @Override
    public Split<MultiScrap> test(MultiScrap scrap) {
      return switch (prop) {
        case X -> scrap.x().lower(value).map(scrap::withX);
        case M -> scrap.m().lower(value).map(scrap::withM);
        case A -> scrap.a().lower(value).map(scrap::withA);
        case S -> scrap.s().lower(value).map(scrap::withS);
      };
    }

    @Override
    public String toString() {
      return prop + "<" + value;
    }
  }

  record GreaterTest(ScrapProp prop, int value) implements ScrapPredicate {

    @Override
    public boolean test(Scrap scrap) {
      return prop.applyAsInt(scrap) > value;
    }

    @Override
    public Split<MultiScrap> test(MultiScrap scrap) {
      return switch (prop) {
        case X -> scrap.x().greater(value).map(scrap::withX);
        case M -> scrap.m().greater(value).map(scrap::withM);
        case A -> scrap.a().greater(value).map(scrap::withA);
        case S -> scrap.s().greater(value).map(scrap::withS);
      };
    }

    @Override
    public String toString() {
      return prop + ">" + value;
    }
  }

}
