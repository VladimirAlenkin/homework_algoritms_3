import java.util.Iterator;
import java.util.LinkedList;

public class homework_algoritms_3 {
    public static void main(String[] args) {
        LinkedList<Employee> linkedList = new LinkedList<>();

        linkedList.addToEnd(new Employee (234, "AAA", "+7123456"));
        linkedList.addToEnd(new Employee(345, "BBB", "+7234567"));
        linkedList.addToEnd(new Employee(456, "CCC", "+7345678"));
        linkedList.addToEnd(new Employee(678, "DDD", "+7456789"));
        linkedList.addToEnd(new Employee(789, "FFF", "+7567890"));

        for (Object employee : linkedList) {
            System.out.println(employee);
        }
        linkedList.reverse();

        System.out.println("*************************************************************");

        for (Object employee : linkedList) {
            System.out.println(employee);
        }
    }

    static class Employee {
        int id;
        String name;
        String phone;

        public Employee(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }
    }

    /**
     * Класс списка
     *
     * @param <T>
     */
    public static class LinkedList<T> implements Iterable {
        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        /**
         * Класс отдельного элемента
         *
         * @param <T>
         */
        private static class ListItem<T> {
            T data;
            ListItem<T> next;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addToEnd(T item) {

            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;

            if (isEmpty()) {
                head = newItem;
                tail = newItem;

            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        
        public void reverse() {
            if (!isEmpty() && head.next != null) { 
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}