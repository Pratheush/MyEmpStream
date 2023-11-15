package com.oldexample.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class MyStrm {
    public static void main(String[] args) {
        int a[]={7,6,5,4,3,2,1};
        long b[]={7,6,5,4,3,2,1};
        double d[]={7,6,5,4,3,2,1};

        IntStream intStream=Arrays.stream(a);
        LongStream longStream=Arrays.stream(b);

        IntStream intStream1=IntStream.of(1,2,3,4,5,6);
        //int max=intStream1.max().getAsInt();
        long max1=longStream.max().getAsLong();

        double avg= Arrays.stream(d).average().getAsDouble();
        double sum=Arrays.stream(d).sum();

        double sumint=intStream1.sum();

        IntSummaryStatistics intSummaryStatistics=intStream.summaryStatistics();
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getSum());

        IntStream.range(1,10).forEach(System.out::print);
        System.out.println();
        IntStream.rangeClosed(1,10).forEach(System.out::print);

        System.out.println();
        // boxed() convert a primitive type stream into stream of objects and vice-versa
        List<Integer> integerList=IntStream.rangeClosed(1,8)
                .boxed()
                .collect(Collectors.toList());
        System.out.println(integerList);

        // usig mapToInt(),mapToLong(),mapToDouble() convert stream of wrapper types into stream of primitives.
        // primitive type streams like IntStream,LongStream,DoubleStream.
        // stream of wrapper types like Stream<Integer>, Stream<Long>, Stream<Double>.
        Arrays.asList(11,12,13,14,15,16,17)
                .stream()
                .mapToInt(i->i)
                .max()
                .getAsInt();

        int imax=Arrays.asList(11,12,13,14,15,16,17)
                .stream()
                .max((i1,i2)->i1.compareTo(i2))
                .get();
        System.out.println(imax);

        //converting Primitive Type Stream to Stream of Objects i.e. Wrappers
        IntStream intStream2=IntStream.of(2,4,6,8,22,33,44);
        Stream<Integer> integerStream=intStream2
                .boxed();

        //converting Stream of Objects to Primitive Type Stream
        // converting Stream<Integer> to stream of Primitive integers
        Stream<Integer> integerStream1=Stream.of(3,5,7,9,1,13,15,17);
        Stream<Integer> integerStream2=Stream.of(3,5,7,9,1,13,15,17);
        Stream<Integer> integerStream3=Stream.of(3,5,7,9,1,13,15,17);
        IntStream intStream3=integerStream1.mapToInt(i->i);
        IntStream intStream4=integerStream2.mapToInt(Integer::valueOf);
        IntStream intStream5=integerStream3.mapToInt(Integer::intValue);
    }
}
