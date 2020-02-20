package org.smacknologs.test;

public interface Observable {

    void register(Observer o);

    void remove(Observer o);

    void notify(Observer o);

    public interface Observer {
	void update(Observable subject);

    }

}
