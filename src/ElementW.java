//Задачи: Практические задачи по Java Core
//        https://habr.com/ru/post/440436/
//
//        2.1. Генерация случайного элемента с весом
//
//        Задача:
//
//        Напишите класс, конструктор которого принимает два массива: массив значений и массив весов значений.
//        Класс должен содержать метод, который будет возвращать элемент из первого массива случайным образом, с учётом его веса.
//        Пример:
//        Дан массив [1, 2, 3], и массив весов [1, 2, 10].
//        В среднем, значение «1» должно возвращаться в 2 раза реже, чем значение «2» и в десять раз реже, чем значение «3».




import java.util.Arrays;

public class ElementW {
    int arr1[];
    int arr2[];
    int rang[];
    int sum;

    ElementW(int[] arr1, int[] arr2) { // конструктор
        this.arr1 = arr1;
        this.arr2 = arr2;
        int len = arr1.length; // длинна массива
        rang = new int[len];
 //       System.out.println("len: " +len);

        //сумма всех весов
        sum = 0;
        for (int arr : arr2)
            sum += arr;
 //       System.out.println("sum: " +sum);

        //массив левых значений
        int tempsum = 0;
        System.out.println(" " );
        for (int i = 0; i < len; i++) {
            rang[i] = tempsum;
            System.out.print("rang: " +" " + rang[i] + "; ");
            tempsum += arr2[i];
        }System.out.println(" ");
    }

    int returns() {

        int rn = (int) ((sum - 1) * Math.random());
        System.out.print(" random: " + rn);
        int index = Arrays.binarySearch(rang, rn);
        System.out.print(" index: "+ index);
        return arr1[index >= 0 ? index : -index - 2];

    }
//        int ourRengIndex = 0;
//        for(int i = 0; i <rang.length; i++) {
//            if (rang[i] > rn) {
//                System.out.println(arr1[i] + " " + rang[i] + " " + rn);
//            break;}
//            ourRengIndex = i;
//        }
//        return arr1[ourRengIndex];

    public static void main(String[] args) {
        int[] arrA = new int[] {10, 2, 30, 20, 45};
        int[] arrB = new int[] {2, 5, 6, 13, 30};
        ElementW elementW = new ElementW(arrA, arrB);
        int znachArr1 = elementW.returns();
        System.out.print(" arr1: "+ znachArr1);
        System.out.println(" ");

    }



      //  for(int i = 0; i< 10; i++)



}
