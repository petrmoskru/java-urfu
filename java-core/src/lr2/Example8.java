package lr2;

public class Example8 {
    public class Animal {
        private String name;
        private int age;
        private String soundMakingMethod;
        public Animal(String name, int age, String soundMakingMethod) {
            this.name = name;
            this.age = age;
            this.soundMakingMethod = soundMakingMethod;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public String getSoundMethod() {
            return soundMakingMethod;
        }
        public void getSoundMethod(String soundMakingMethod) {
            this.soundMakingMethod = soundMakingMethod;
        }
    }

    public class Dog extends Animal {
        private String breed;
        public Dog(String name, int age, String soundMakingMethod, String breed) {
            super(name, age, soundMakingMethod);
            this.breed = breed;
        }
        public String getBreed() {
            return breed;
        }
        public void setBreed(String breed) {
            this.breed = breed;
        }
    }

    public class Cat extends Animal {
        private String foodType;
        public Cat(String name, int age, String soundMakingMethod, String foodType) {
            super(name, age, soundMakingMethod);
            this.foodType = foodType;
        }
        public String getFoodType() {
            return foodType;
        }
        public void setFoodType(String foodType) {
            this.foodType = foodType;
        }
    }

    public class Bird extends Animal {
        private boolean isFly;
        public Bird(String name, int age, String soundMakingMethod, boolean isFly) {
            super(name, age, soundMakingMethod);
            this.isFly = isFly;
        }
        public boolean getIsFly() {
            return isFly;
        }
        public void setIsFly(boolean isFly) {
            this.isFly = isFly;
        }
    }

    public abstract class Shape {
        public abstract double calculateArea();
        public abstract double calculatePerimeter();
    }

    public class Circle extends Shape {
        private double radius;
        public Circle(double radius) {
            this.radius = radius;
        }
        public double getRadius() {
            return radius;
        }
        public void setRadius(double radius) {
            this.radius = radius;
        }
        @Override
        public double calculateArea() {
            return Math.PI * radius * radius;
        }
        @Override
        public double calculatePerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    public class Square extends Shape {
        private double side;
        public Square(double side) {
            this.side = side;
        }
        public double getSide() {
            return side;
        }
        public void setSide(double side) {
            this.side = side;
        }
        @Override
        public double calculateArea() {
            return side * side;
        }
        @Override
        public double calculatePerimeter() {
            return 4 * side;
        }
    }

    public class Triangle extends Shape {
        private double side1;
        private double side2;
        private double side3;
        public Triangle(double side1, double side2, double side3) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        public double getSide1() {
            return side1;
        }
        public void setSide1(double side1) {
            this.side1 = side1;
        }
        public double getSide2() {
            return side2;
        }
        public void setSide2(double side2) {
            this.side2 = side2;
        }
        public double getSide3() {
            return side3;
        }
        public void setSide3(double side3) {
            this.side3 = side3;
        }
        @Override
        public double calculateArea() {
            double s = (side1 + side2 + side3) / 2;
            return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        }
        @Override
        public double calculatePerimeter() {
            return side1 + side2 + side3;
        }
    }
}
