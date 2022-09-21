package ocp17.Ch10;

import java.util.stream.*;
import java.util.*;
import java.util.function.*;;

public class Streams {
        public static void main(String[] args) {
                Stream<String> empty = Stream.empty(); // count = 0
                Stream<Integer> singleElement = Stream.of(1); // count = 1
                Stream<Integer> fromArray = Stream.of(1, 2, 3); // count = 3

                var list = List.of("a", "b", "c");
                Stream<String> fromList = list.stream();
                Stream<String> fromListParallel = list.parallelStream();

                Stream<Double> randoms = Stream.generate(Math::random);
                Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
                Stream<Integer> oddNumberUnder100 = Stream.iterate(1, n -> n < 100, n -> n + 2); // UnaryOperator to get
                                                                                                 // next
                                                                                                 // value);
        }

        void terminalOps() {
                Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
                System.out.println(s.count()); // 3

                Stream<String> ss = Stream.of("monkey", "ape", "bonobo");
                Optional<String> min = ss.min((s1, s2) -> s1.length() - s2.length());
                min.ifPresent(System.out::println); // ape

                Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
                System.out.println(minEmpty.isPresent()); // false

                // a stream can have only one terminal operation
                // Once a terminal operation has been run, the stream cannot be used against

                Stream<String> sss = Stream.of("monkey", "gorilla", "bonobo");
                Stream<String> infinite = Stream.generate(() -> "chimp");
                sss.findAny().ifPresent(System.out::println); // monkey (usually)
                infinite.findAny().ifPresent(System.out::println); // chimp

                var list = List.of("monkey", "2", "chimp");
                Stream<String> infinite2 = Stream.generate(() -> "chimp");
                Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

                System.out.println(list.stream().anyMatch(pred)); // true
                System.out.println(list.stream().allMatch(pred)); // false
                System.out.println(list.stream().noneMatch(pred)); // false
                System.out.println(infinite2.anyMatch(pred)); // true

                Stream<String> apes = Stream.of("Monkey", "Gorilla", "Bonobo");
                apes.forEach(System.out::print); // MonkeyGorillaBonobo

                Stream<Integer> one = Stream.of(1);
                for (Integer i : one) {
                } // DOES NOT COMPILE

                var array = new String[] { "w", "o", "l", "f" };
                var result = "";
                for (var item : array)
                        result = result + item;
                System.out.println(result); // wolf

                Stream<String> stream = Stream.of("w", "o", "l", "f");
                String word = stream.reduce("", (sp, c) -> sp + c);
                System.out.println(word); // wolf

                Stream<String> stream2 = Stream.of("w", "o", "l", "f");
                String word2 = stream.reduce("", String::concat);
                System.out.println(word2); // wolf

                Stream<Integer> stream3 = Stream.of(3, 5, 6);
                System.out.println(stream3.reduce(1, (a, b) -> a * b)); // 90

                BinaryOperator<Integer> op = (a, b) -> a * b;
                Stream<Integer> empty = Stream.empty();
                Stream<Integer> oneElement = Stream.of(3);
                Stream<Integer> threeElements = Stream.of(3, 5, 6);
                empty.reduce(op).ifPresent(System.out::println);
                oneElement.reduce(op).ifPresent(System.out::println);
                threeElements.reduce(op).ifPresent(System.out::println); // 90

                Stream<String> stream4 = Stream.of("w", "o", "l", "f!");
                int length = stream4.reduce(0, (i, sp) -> i + sp.length(), (a, b) -> a + b);
                System.out.println(length); // 5

        }

        void collecting() {
                Stream<String> stream = Stream.of("w", "o", "l", "f");
                StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
                System.out.println(word); // wolf

                Stream<String> stream2 = Stream.of("w", "o", "l", "f");
                TreeSet<String> set = stream2.collect(TreeSet::new,
                                TreeSet::add,
                                TreeSet::addAll);
                System.out.println(set); // [f, l, o, w]

                Stream<String> stream3 = Stream.of("w", "o", "l", "f");
                TreeSet<String> set2 = stream3.collect(Collectors.toCollection(TreeSet::new));
                System.out.println(set2); // [f, l, o, w]

                Stream<String> stream4 = Stream.of("w", "o", "l", "f");
                Set<String> set3 = stream4.collect(Collectors.toSet());
                System.out.println(set3); // [f, w, l, o]
        }

        void streamOps() {
                Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
                s.filter(x -> x.startsWith("m"))
                                .forEach(System.out::print); // monkey

                Stream<String> ss = Stream.of("duck", "duck", "duck", "goose");
                ss.distinct()
                                .forEach(System.out::print); // duckgoose

                Stream<Integer> sp = Stream.iterate(1, n -> n + 1);
                sp.skip(5)
                                .limit(2).forEach(System.out::print); // 67

                Stream<String> sm = Stream.of("monkey", "gorilla", "bonobo");
                sm.map(String::length)
                                .forEach(System.out::print); // 676

                List<String> zero = List.of();
                var one = List.of("Bonobo");
                var two = List.of("Mama Gorilla", "Baby Gorilla");
                Stream<List<String>> animals = Stream.of(zero, one, two);
                animals.flatMap(m -> m.stream()).forEach(System.out::println);

                var one1 = Stream.of("Bonobo");
                var two2 = Stream.of("Mama Gorilla", "Baby Gorilla");
                Stream.concat(one1, two2).forEach(System.out::println);
        }

        void sorting() {
                Stream<String> st = Stream.of("brown-", "bear-");
                st.sorted()
                                .forEach(System.out::print); // bear-brown-

                Stream<String> s = Stream.of("brown bear-", "grizzly-");
                s.sorted(Comparator.reverseOrder())
                                .forEach(System.out::print); // grizzly-brown bear-

                var stream = Stream.of("black bear", "brown bear", "grizzly");
                long count = stream.filter(sc -> sc.startsWith("g"))
                                .peek(System.out::println).count(); // grizzly
                System.out.println(count); // 1

                var list = List.of("Toby", "Anna", "Leroy", "Alex");
                List<String> filtered = new ArrayList<>();
                for (String name : list)
                        if (name.length() == 4)
                                filtered.add(name);
                Collections.sort(filtered);
                var iter = filtered.iterator();
                if (iter.hasNext())
                        System.out.println(iter.next());
                if (iter.hasNext())
                        System.out.println(iter.next());
        }

        void filtering() {
                var list = List.of("Toby", "Anna", "Leroy", "Alex");
                list.stream()
                                .filter(n -> n.length() == 4).sorted()
                                .limit(2).forEach(System.out::println);
                Stream.generate(() -> "Elsa").filter(n -> n.length() == 4).limit(2)
                                .sorted().forEach(System.out::println);

                Stream.generate(() -> "Olaf Lazisson").filter(n -> n.length() == 4).limit(2)
                                .sorted().forEach(System.out::println);

                long count = Stream.of("goldfish", "finch").filter(s -> s.length() > 5).collect(Collectors.toList())
                                .stream()
                                .count();
                System.out.println(count); // 1
                List<String> helper = Stream.of("goldfish", "finch").filter(s -> s.length() > 5)
                                .collect(Collectors.toList());
                long count = helper.stream().count();
                System.out.println(count);
        }

        voir primitives() {
                Stream<Integer> stream = Stream.of(1, 2, 3);
                System.out.println(stream.reduce(0, (s, n) -> s + n)); // 6

                Stream<Integer> stream = Stream.of(1, 2, 3);
                System.out.println(stream.mapToInt(x -> x).sum()); // 6

                IntStream intStream = IntStream.of(1, 2, 3);
                OptionalDouble avg = intStream.average();
                System.out.println(avg.getAsDouble()); // 2.0

                DoubleStream empty = DoubleStream.empty();
                DoubleStream oneValue = DoubleStream.of(3.14);
                oneValue.forEach(System.out::println);
                DoubleStream varargs = DoubleStream.of(1.0, 1.1, 1.2);
                varargs.forEach(System.out::println);

                var random = DoubleStream.generate(Math::random);
                var fractions = DoubleStream.iterate(.5, d -> d / 2);
                random.limit(3).forEach(System.out::println);
                fractions.limit(3).forEach(System.out::println);

                IntStream count = IntStream.iterate(1, n -> n + 1).limit(5);
                count.forEach(System.out::print); // 12345

                IntStream range = IntStream.range(1, 6);
                range.forEach(System.out::print); // 12345

                IntStream rangeClosed = IntStream.rangeClosed(1, 5);
                rangeClosed.forEach(System.out::print); // 12345

                Stream<String> objStream = Stream.of("penguin", "fish");
                IntStream intStream = objStream.mapToInt(s -> s.length());

                var integerList = new ArrayList<Integer>();
                IntStream ints = integerList.stream()
                                .flatMapToInt(x -> IntStream.of(x));
                DoubleStream doubles = integerList.stream()
                                .flatMapToDouble(x -> DoubleStream.of(x));
                LongStream longs = integerList.stream()
                                .flatMapToLong(x -> LongStream.of(x));

                var stream = IntStream.rangeClosed(1, 10);
                OptionalDouble optional = stream.average();

                optional.ifPresent(System.out::println);
                System.out.println(optional.getAsDouble());
                System.out.println(optional.orElseGet(() -> Double.NaN));

                LongStream longs = LongStream.of(5, 10);
                long sum = longs.sum();
                System.out.println(sum); // 15
                DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
                OptionalDouble min = doubles.min(); // runs infinitely
        }

        private static Stream<Integer> mapping(IntStream stream) {
                return stream.mapToObj(x -> x);
        }

        private static Stream<Integer> boxing(IntStream stream) {
                return stream.boxed();
        }

        private static int max(IntStream ints) {
                OptionalInt optional = ints.max();
                return optional.orElseThrow(RuntimeException::new);
        }

        private static int range(IntStream ints) {
                IntSummaryStatistics stats = ints.summaryStatistics();
                if (stats.getCount() == 0)
                        throw new RuntimeException();
                return stats.getMax() - stats.getMin();
        }
}
