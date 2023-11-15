package com.oldexample.company;

import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.*;

public class MyStrm1 {
    static String s1;
    static String s2;
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

        // IntSummaryStatistics, LongSummaryStatistics, DoubleSummaryStatistics
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

        // using mapToInt(),mapToLong(),mapToDouble() convert stream of wrapper types into stream of primitives.
        // primitive type streams like IntStream,LongStream,DoubleStream.
        // stream of wrapper types like Stream<Integer>, Stream<Long>, Stream<Double>.
        int intmax=Arrays.asList(11,12,13,14,15,16,17)
                .stream()
                .mapToInt(Integer::valueOf)
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

        BigDecimal salary;

        int baeldungSum=Arrays.asList(33,34,35,36)
                .stream()
                .mapToInt(i->i)
                .sum();

        long longarray[]={7,6,5,4,3,2,1};
        LongStream longStream1=Arrays.stream(longarray);
        LongStream longStream2=LongStream.of(1,2,3,4,5);

        List<Integer> ilist=List.of(11,22,33,44,55,66,77,88);
        IntStream istream=ilist.stream().mapToInt(i->i);

        Stream<Double> boxedStream= DoubleStream.of(8,2,7,3,4,6,5,9,1).boxed();
        //boxedStream.iterator().forEachRemaining(System.out::println); // this is also right
        // forEachOrdered always guarantee the encounter order.
        // forEach is not necessarily the encounter order.
        boxedStream.forEachOrdered(System.out::println);

        List<Long> longlist=Arrays.asList(new Long[]{1l,2l,3l,4l,5l});
        List<Long> longList1=Arrays.asList(10l,9l,8l,7l,6l,5l);
        System.out.println(longList1);
        int[] intArray=new int[]{0,1,2,3};
        int[] intArray1={0,1,2,3};
        int[] intArray2=new int[3];
        intArray2[0]=1;
        for (int i:intArray2
        ) {
            System.out.println(i);

        }

        int[] iarray=new int[]{12,13,14,15,16,17};
        List<Integer> ilist2=IntStream.of(iarray)
                .boxed()
                .collect(Collectors.toList());

        long[] larray=Arrays.asList(3l,4l,5l,6l,7l)
                .stream()
                .mapToLong(Long::longValue)
                .toArray();

        // toArray() method is used to convert the elements of a stream into an array of the specified type.
        // thus returning an array containing the elements of the stream.
        Long[] larray2=Arrays.asList(3l,4l,5l,6l,7l)
                .stream()
                .toArray(Long[]::new);

        Long[] larray3=Arrays.asList(3l,4l,5l,6l,7l)
                .toArray(Long[]::new);

        Long[] larray4=Arrays.asList(3l,4l,5l,6l,7l)
                .toArray(new Long[0]);
        System.out.println("length::"+larray4.length);
        Arrays.stream(larray4).iterator().forEachRemaining(System.out::println);


        // Using Apache Commons Lang :: StringUtils :: equals anc compare methods which also handles null values.
        // StringUtils also has equalsIgnoreCase() compareIgnoreCase() methods
        //System.out.println(s1.compareTo(s2));
        System.out.println(StringUtils.equals(s1,s2));
        System.out.println(StringUtils.compare(s1,s2));

        System.out.println(s1.compareToIgnoreCase("using compareToIgnoreCase()"+s2));
    }
}
