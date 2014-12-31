package beans;

/**
 * Created by doliu on 12/22/14.
 */
public class ABC {
	public int a, b, c;
	public ABC(int a, int b, int c) {
		this.a=a;this.b=b;this.c=c;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ABC)) return false;
		ABC other = (ABC)obj;
		return this.a == other.a && this.b == other.b && this.c == other.c;
	}
}
