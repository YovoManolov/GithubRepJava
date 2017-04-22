package Threads;

class Downloader extends Thread { 
    private String url;
    public Downloader (String url){
    	this.url = url;
    }
    public void run(){
    	FileDownloader fd = new FileDownloader();
    	fd.dowload(this.url);
    }
}
