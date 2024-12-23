## Отчет по лабораторной работе № 3

#### № группы: `ПМ-2402`

   #### Выполнил: `Ковалев Артемий Алексеевич`

#### Вариант: `12`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

> **Разработать программу для работы с множествами, представляющими списки уникальных элементов. Реализовать базовые операции, включая добавление и удаление элементов, 
а также сложные операции, такие как объединение, пересечение и проверка
вложенности множеств.

Данную задачу можно разделить на 12 подзадач: 

1. Создание множества
   Создание множества из:
   • пустого списка;
   • массива чисел;
   • n чисел, вводимых с консоли.
   Во всех случаях проверяются и удаляются повторяющиеся элементы.
2. Вывод множества
   Отображение всех элементов множества.
3. Добавление элемента
   Добавление нового элемента в множество, если он ещё не содержится в нём.
4. Удаление элемента
   Удаление указанного элемента из множества, если он содержится в нём.
5. Подсчёт количества элементов
   Возвращает текущее количество элементов в множестве.
6. Проверка принадлежности элемента
   Определяет, содержится ли указанный элемент в множестве.
7. Объединение множеств
   Возвращает множество, содержащее элементы, которые есть хотя бы в одном из
   двух множеств.
8. Пересечение множеств
   Возвращает множество, содержащее элементы, которые есть одновременно в обоих
   множествах.
9. Симметрическая разность множеств
   Возвращает множество, содержащее элементы, которые есть ровно в одном из
   двух множеств.
10. Разность множеств
    Удаляет из текущего множества все элементы, содержащиеся в переданном множестве.
    21
11. Сравнение множеств
    Определяет, совпадают ли два множества (имеют одинаковые элементы).
12. Проверка вложенности множеств
    Определяет:
    • Содержится ли переданное множество в текущем;
    • Содержит ли текущее множество переданное.


### 2. Входные и выходные данные

#### Данные на вход

На вход программы подаются: или массив целых чисел, или натуральное число N, затем N целых чисел. Верхняя граница получаемых
чисел не дана.

|                              | Тип                  | min значение | max значение |
|------------------------------|----------------------|--------------|--------------|
| N (количество целых чисел)   | Целое число          | 1            | Нет          |
| A (одно из N целых чисел)    | Целое число          | Нет          | Нет          |
| numbers (массив целых чисел) | Целочисленный массив | Нет          | Нет          |

#### Данные на выход

Программа должна вывести обработанное множество. 

|          | Тип                | min значение | max значение |
|----------|--------------------|--------------|--------------|
| set1     | Sets               | Нет          | Нет          |
 

### 3. Выбор структуры данных
Для работы класса создаём две переменные: массив (`elements`) типа `int` и 
переменную (`l`) типа `int`, которая будет хранить длину массива `elements`.

|                               | название переменной | Тип (в Java) | 
|-------------------------------|---------------------|--------------|
| l (длина массива)             | `l`                 | `int`        |
| elements (массив целых чисел) | `elements`          | `int`        |


### 4. Алгоритм

#### Алгоритм выполнения программы:

1. **Ввод данных:**
    Чтобы создать множество на основе введённого массива целых чисел, метод класса `Sets` перебирает этот массив через цикл `for` и к каждому элементу
применяет метод `addNewElenent()`. Аналогично с созданием множества из `n` чисел, вводимых с консоли. 

2. **Методы, используемые для создания множества**  
  Метод `addNewElement` использует два встроенных метода:`resize`, который изменяет размер массива `elements` и `isExist`, который проверяет,
существует ли элемент, который мы хотим добавить в текущем множестве. Каждый из этих методов реализуется при помощи цикла `for`, который перебирает элементы в массиве.
Таким образом метод addNewElement применяется для всех методов создания множества и полностью удовлетворяет условиям существования множества, на основе массивов. 

3. **Методы, используемые для обработки множеств**
   Методы для вывода и удаления элемента из множества (`printSet`, `deleteElement` соответственно) так же основаны на работе цикла `for`. В методе `delete`
   Мы проверяем, существует ли указанный элеимент в множестве.
   Метод для подсчёта количества элементов (`countElements`) просто возвращает длину текущего массива.

4. **Методы, реализующие основные операции множеств**
   Методы для реализации основных операций множеств (`unification`-объединение, `intersection`-пересечение, `symmetricDifference`-симметрическая разность)
создают и возвращают в результате новое множество, в котором содержатся элементы, требуемые в зависимости от операции. В каждом из этих методов используется 
цикл `for` для перебора элементов массивов. Метод `difference` так же с помощью цикла и встроенных методов изменяет текущее множество.
5. **Методы, сравнивающие два множества**
    Три метода `equality`, `includeCurrent`, `includeAnother` проверяют равенство и вложенность множеств, каждый из них возвращают ответ типа `boolean`.
6. **Вывод результата:**  
   Тестирование работы класса и вывод результатов происходит в главной программе.

   
### 5. Программа

```java

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


```

### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений.

`
Элементы множества: 
1
2
27
Элементы множества: 
1
2
3
4
5
Элементы множества: 
5
8
24
6
Количество элементов в set1: 3
Содержится 1 в set1: true
После удаления 1 из set1:
Элементы множества: 
2
27
После удаления 3 из set2:
Элементы множества: 
1
2
4
5
Объединение set1 и set2:
Элементы множества: 
2
27
1
4
5
Пересечение set1 и set2:
Элементы множества: 
2
Симметрическая разность set1 и set2:
Элементы множества: 
27
1
4
5
Разность set1 и set2:
Элементы множества: 
27
set1 равен set2: false
set1 содержит set2: false
set2 содержится в set1: false
`
      