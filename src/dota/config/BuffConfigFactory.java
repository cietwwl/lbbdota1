package dota.config;

public class BuffConfigFactory extends AbstractConfigFactory<BuffConfig>{

	private static BuffConfigFactory instance = null;
	
	public static BuffConfigFactory getInstance() {
		if(instance == null) {
			instance = new BuffConfigFactory();
			instance.init();
		}
		return instance;
	}
	
	@Override
	public void init() {
		array = new BuffConfig[2];
		BuffConfig e0 = new BuffConfig();
		e0.buffType = 0;
		e0.name = "强化图腾";
		e0.time = 3;
		e0.arg0 = 200;
		array[0] = e0;
		
		BuffConfig e1 = new BuffConfig();
		e1.buffType = 1;
		e1.name = "余震";
		e1.time = 99999;
		e1.arg0 = 100;
		e1.arg1 = 1;
		array[1] = e1;
				
	}

}
