package lr2;

public class Example5 {
    public class Rectangle {
        private double width;
        private double length;

        public Rectangle(double width, double length) {
            this.width = width;
            this.length = length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getLength() {
            return length;
        }

        public double getWidth() {
            return width;
        }

        public double squareRectangle() {
            return length * width;
        }

        public double perimeterRectangle() {
            return 2 * (length + width);
        }
    }
}
