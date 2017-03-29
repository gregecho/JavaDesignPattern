package com.greg.javadesignpattern.File;

public interface File {
	public void add(AbstractFile file);  
    public void remove(AbstractFile file);  
    public AbstractFile getChild(int i);  
    public void killVirus();  
}
