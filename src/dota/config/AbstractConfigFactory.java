package dota.config;

public abstract class AbstractConfigFactory<T> {
	protected T[] array = null;
	
	public abstract void init();
	
	public T getConfig(int index) {
		return array[index];
	}
	
}
