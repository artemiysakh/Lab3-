import java.util.Scanner;
class Sets{
    private int []elements; //Переменная массива
    private int l; //Переменная длины массива

    // Конструктор для создания пустого множества
    public Sets(){
        this.elements = new int[0];
        this.l=0;
    }
    // Конструктор для создания множества из массива
    public Sets(int[] numbers){
        this.l=0;
        this.elements = new int[l];

        for(int i=0; i<numbers.length; i++){
            addNewElement(numbers[i]);
        }
    }
    // Конструктор для создания множества из ввода с консоли
    public Sets(int n){
        this.l=0;
        this.elements = new int[l];

        Scanner in = new Scanner(System.in);
        System.out.println("Введите " + n + " чисел:");

        while(n>0){
            addNewElement(in.nextInt());
            n--;
        }
    }
    // Метод для вывода множества
    public void printSet(){
        System.out.println("Элементы множества: ");
        for(int i=0; i<this.elements.length; i++){
            System.out.println(this.elements[i]);
        }
    }
    // Метод для добавления элемента
    public void addNewElement(int n) {
        if(!isExist(n)){
            if(l==elements.length){
                resize();
            }
            elements[l++]=n;
        }
    }
    //Вспомогательный метод для изменения размера массива
    public void resize(){
        int newL;
        if(l==0)
            newL=1;
        else
            newL= l+1;
        int [] newElements = new int[newL];
        for(int i=0; i<elements.length; i++){
                newElements[i]=elements[i];
        }
        elements = newElements;
    }
    // Метод для удаления элемента
    public void deleteElement(int n){
        int l = 0;
        for(int i=0; i<elements.length; i++){
            if(elements[i]==n){
                l++;
            }
        }
        if(l!=0) {
            l = elements.length - 1;
            int[] result = new int[l];
            for (int i = 0, j = 0; i < elements.length; i++) {
                if (elements[i] != n) {
                    result[j] = elements[i];
                    j++;
                }
            }
            this.elements = result;
        }
    }
    // Метод для подсчета количества элементов
    public int countElements(){
        return elements.length;
    }
    // Метод для проверки принадлежности элемента
    public boolean isExist(int n){
        boolean res = false;
        for(int i=0;i<elements.length; i++){
            if(elements[i]==n){
                res=true;
            }
        }
        return res;
    }
    // Метод для объединения множеств
    public Sets unification(Sets another){
        Sets result = new Sets();
        for(int i=0; i<this.elements.length; i++)
            result.addNewElement(this.elements[i]);
        for(int i=0; i<another.elements.length; i++){
            if(!isExist(another.elements[i]))
                result.addNewElement(another.elements[i]);
        }
        return result;
    }
    // Метод для пересечения множеств
    public Sets intersection(Sets another){
        Sets result = new Sets();
        for(int i=0; i<another.elements.length; i++){
            if(this.isExist(another.elements[i]))
                result.addNewElement(another.elements[i]);
        }
        return result;
    }
    // Метод для симметрической разности
    public Sets symmetricDifference(Sets another){
        Sets result = this.unification(another);
        Sets intersection = this.intersection(another);
        for(int i=0; i<intersection.countElements(); i++){
            if(result.isExist(intersection.elements[i])){
                result.deleteElement(intersection.elements[i]);
            }
        }
        return result;
    }
    // Метод для разности множеств
    public void difference(Sets another){
        for(int i=0; i<countElements(); i++){
            if(another.isExist(this.elements[i])){
                deleteElement(this.elements[i]);
            }
        }
    }
    // Метод для сравнения множеств
    public boolean equality(Sets another){
        boolean res=true;
        int k = this.elements.length;
        int j = another.elements.length;
        if (k == j){
            for (int i=0; i<j;i++){
                if(!isExist(another.elements[i]))
                    res=false;
            }
        }else{
            res=false;
        }
        return res;
    }
    // Метод для проверки вложенности множеств
    public boolean includeCurrent(Sets another){
        boolean res = true;
        for (int i=0; i<another.elements.length;i++){
            if(!isExist(another.elements[i]))
                res=false;
        }
        return res;
    }
    public boolean includeAnother(Sets another){
        boolean res = true;
        for (int i=0; i<this.elements.length;i++){
            if(!another.isExist(this.elements[i]))
                res=false;
        }
        return res;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sets set1 = new Sets(); // создание пустого множества
        Sets set2 = new Sets(new int[]{1, 2, 3, 4, 4, 5}); // создание из массива
        Sets set3 = new Sets(5); // создание из ввода с консоли

        set1.addNewElement(1);
        set1.addNewElement(1);
        set1.addNewElement(2);
        set1.addNewElement(27);

        set1.printSet();
        set2.printSet();
        set3.printSet();

        System.out.println("Количество элементов в set1: " + set1.countElements());
        System.out.println("Содержится 1 в set1: " + set1.isExist(1));

        set1.deleteElement(1);
        set2.deleteElement(3);
        System.out.println("После удаления 1 из set1:");
        set1.printSet();
        System.out.println("После удаления 3 из set2:");
        set2.printSet();

        Sets unificationSet = set1.unification(set2);
        System.out.println("Объединение set1 и set2:");
        unificationSet.printSet();

        Sets intersectionSet = set1.intersection(set2);
        System.out.println("Пересечение set1 и set2:");
        intersectionSet.printSet();

        Sets symmetricDiffSet = set1.symmetricDifference(set2);
        System.out.println("Симметрическая разность set1 и set2:");
        symmetricDiffSet.printSet();

        set1.difference(set2);
        System.out.println("Разность set1 и set2:");
        set1.printSet();

        System.out.println("set1 равен set2: " + set1.equality(set2));
        System.out.println("set1 содержит set2: " + set1.includeCurrent(set2));
        System.out.println("set2 содержится в set1: " + set2.includeAnother(set1));

    }
}
