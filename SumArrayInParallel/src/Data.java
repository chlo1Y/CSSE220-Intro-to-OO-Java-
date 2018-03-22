class Data {
	public int[] a;
	//TODO Some changes are necessary in this class
	public long b;
	
	public void setData(int n) {
		this.a = new int[n];
		for(int i = 0; i < n; i++) {
			double randSign = Math.random();
			double randVal = Math.random();
			int sign = (randSign < 0.5) ? -1 : 1;
			this.a[i] = (int)(randVal * n) * sign;
		}
		this.b = 0;
	}
}