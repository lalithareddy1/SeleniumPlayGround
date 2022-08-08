package assignments_numpy;

public class Student {

	public float cal_sum(float maths, float english, float social, float science) {
		float sum = maths + english + social + science;
		return sum;

	}

	public float cal_average(float sum) {
		float average = sum / 4;
		return average;
	}

	public static void main(String[] args) {
		Student s1 = new Student();
		float sum_value = s1.cal_sum(98, 90, 85, 80);
		float average_value = s1.cal_average(sum_value);
		System.out.println("Student 1 sum :" + sum_value);
		System.out.println("Average of student1 :" + average_value);

		Student s2 = new Student();
		float s2_sum_value = s2.cal_sum(95, 80, 84, 89);
		float s2_average_value1 = s2.cal_average(s2_sum_value);
		System.out.println("Student 1 sum :" + s2_sum_value);
		System.out.println("Average of student1 :" + s2_average_value1);

	}

}
