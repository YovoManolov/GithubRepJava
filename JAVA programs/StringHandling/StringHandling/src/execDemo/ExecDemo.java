package execDemo;

class ExecDemo {

	public static void main(String[] args) {
	    Runtime r =  Runtime.getRuntime ();
        Process p = null;
        
        try{
        	p = r.exec("Calculator");
        	p.waitFor();
        }catch(Exception e){
        	//Exception don't require class specification ;
        	System.out.println("Error executing notepad !");
        }
        
        System.out.println("Notepad  returned: " + p.exitValue());
	}

}
