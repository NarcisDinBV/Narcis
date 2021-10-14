package ro.sci.temasapt4.week4.vehicles;


    class Person {
        private String name;
        private String surname;
        private int age;
        private boolean hungry;

        public Person(String name, String surname, int age, boolean hungry) {
            this.name = name;
            this.surname = surname;
            this.age = age;
            this.hungry = hungry;
        }

        public String toString() {
            return this.name + " " + this.surname +
                    " " + (this.hungry ? "is" : "is not")  + " " +
                    "hungry";
        }
        void eat() {
            this.hungry = false;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }
    }

