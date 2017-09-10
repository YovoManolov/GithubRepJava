алгоритми

int fact(int n){
	if(n <= 1){
		return 1;
	}else{
	return n*fact(n-1)
	}
}


Най-голям общ делител на 2 естествени числа

int min(int p,int x){
	if(p>x)return x;
	else return p;
}

int nod (int c, int d){
	if(c == d) return c;
	else return nod(abs(c-d),min(c,d));
}


reverse естествено число
int a(int a){
	if(a < 10) cout << a; 
	else{

		cout << a%10 ;
		the same(a/10);
	
	}
}


ХАНОЙ

void hanoy(char a, char c,char b, unsigned numb){
	if(1 == numb){
		diskMove(1,a,c);
	}else {
		hanoy(a,b,c,n-1);
		diskMove(1,a,c);
		hanoy(b,c,a,n-1);
	}
}


void diskMove(unsigned N ,char a,char b){
	cout << N << a << b << endl;
}


float power (float chislo ,int stepen){
	if(stepen = 0) return 1;
	else {
		if(stepen > 0) return chislo*power(chislo,stepen-1);
		else return 1/power(chislo,-stepen);
}


furie for 


furie 


0 1 1 2 3 5 8 13 21 

void 