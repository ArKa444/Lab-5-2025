package functions;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование методов toString(), equals(), hashCode(), clone()\n ");
        System.out.println();
        
        //создаем тестовые точки
        FunctionPoint point1 = new FunctionPoint(1.0, 2.0);
        FunctionPoint point2 = new FunctionPoint(2.0, 4.0);
        FunctionPoint point3 = new FunctionPoint(3.0, 6.0);
        
        //создаем массивы точек для функций
        FunctionPoint[] points1 = {point1, point2, point3};
        FunctionPoint[] points2 = {point1, point2, point3}; //одинак. точки
        FunctionPoint[] points3 = {new FunctionPoint(1.0, 2.0), new FunctionPoint(2.0, 5.0), new FunctionPoint(3.0, 6.0)}; 
        
        //создаем объект ф-ии
        ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
        ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);
        
        LinkedListTabulatedFunction listFunc1 = new LinkedListTabulatedFunction(points1);
        LinkedListTabulatedFunction listFunc2 = new LinkedListTabulatedFunction(points2);
        
        //тестирование метода toString()
        System.out.println("1. Метод toString():");
        System.out.println("ArrayTabulatedFunction: " + arrayFunc1.toString());
        System.out.println("LinkedListTabulatedFunction: " + listFunc1.toString());
        System.out.println();
        
        //тестирование метода equals()
        System.out.println("2. Метод equals():");
        System.out.println("arrayFunc1.equals(arrayFunc2): " + arrayFunc1.equals(arrayFunc2));
        System.out.println("arrayFunc1.equals(arrayFunc3): " + arrayFunc1.equals(arrayFunc3));
        System.out.println("arrayFunc1.equals(listFunc1): " + arrayFunc1.equals(listFunc1));
        System.out.println("listFunc1.equals(listFunc2): " + listFunc1.equals(listFunc2));
        System.out.println();
        
        //тестирование метода hashCode()
        System.out.println("3. Метод hashCode():");
        System.out.println("arrayFunc1 hashCode: " + arrayFunc1.hashCode());
        System.out.println("arrayFunc2 hashCode: " + arrayFunc2.hashCode());
        System.out.println("arrayFunc3 hashCode: " + arrayFunc3.hashCode());
        System.out.println("listFunc1 hashCode: " + listFunc1.hashCode());
        System.out.println("listFunc2 hashCode: " + listFunc2.hashCode());
        System.out.println();
        
        //проверка изм. хэш при изм. объекта
        System.out.println("Проверка изменения хэш-кода:");
        System.out.println("point1 hashCode до изменения: " + point1.hashCode());
        point1.setY(2.1);
        System.out.println("point1 hashCode после изменения: " + point1.hashCode());
        System.out.println("Хэш-код изменился: " + (point1.hashCode() != new FunctionPoint(1.0, 2.0).hashCode()));
        System.out.println();
        
        //тестирование метода clone()
        System.out.println("4. Метод clone():");
        
        //клонируем ф-ию
        ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) arrayFunc1.clone();
        LinkedListTabulatedFunction listClone = (LinkedListTabulatedFunction) listFunc1.clone();
        
        System.out.println("arrayClone.equals(arrayFunc1): " + arrayClone.equals(arrayFunc1));
        System.out.println("listClone.equals(listFunc1): " + listClone.equals(listFunc1));
        System.out.println();
        
        //проверка глубокого копирования
        System.out.println("Проверка глубокого клонирования:");
        double originalValue = arrayFunc1.getPointY(0); //сохраняеи исх.знач.
        System.out.println("Исходное значение arrayFunc1: " + originalValue);
        
        arrayFunc1.setPointY(0, 100.0); //изменяем ориг. ф-ию
        System.out.println("arrayFunc1 после изменения: " + arrayFunc1.getPointY(0));
        System.out.println("arrayClone после изменения оригинала: " + arrayClone.getPointY(0));
        System.out.println("Клон не изменился: " + (arrayClone.getPointY(0) == originalValue));
        
        System.out.println();
        
    }
}