package br.com.playdreamcraft.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import br.com.playdreamcraft.ProxyLogin;

/**
 * Classe para gerenciamento do arquivo de configuração do tipo Yaml
 * @author _LucasD
 *
 */
public class YamlConfiguration 
{	
	private static ArrayList<YamlConfiguration> configs = new ArrayList<>();
	private Configuration config;
	private static ProxyLogin mainInstance;
	private File configFile;
	private ConfigurationOptions options;
	private String configName;
	boolean defaultConfig;
	
	private YamlConfiguration(String configName)
	{
		if(YamlConfiguration.mainInstance ==null)
		 YamlConfiguration.mainInstance = ProxyLogin.getInstance();		
		
		defaultConfig = (configName == "config");
		this.configName = configName;
		configFile = new File(YamlConfiguration.mainInstance.getDataFolder(),this.configName+".yml");
		
		setupConfig();
	}

	
	/**
	 * Faz o setup de uma configuração
	 */
	private void setupConfig()
	{
		if(!mainInstance.getDataFolder().exists()) //caso não existir a pasta do plugin
		{
			try 
			{
				Files.copy(mainInstance.getResourceAsStream(configName+".yml"), configFile.toPath(), new CopyOption[]
				{						
					StandardCopyOption.COPY_ATTRIBUTES
				});
				mainInstance.getLogger().warning("Configuracao padrao gerada!");				
			} catch (IOException e) 
			{
				mainInstance.getLogger().warning("Não foi possivel copiar a configuracao padrao!");
				e.printStackTrace();
			}
		}
		try 
		{
			config = ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class).load(configFile);
		} catch (IOException e) 
		{		
			mainInstance.getLogger().warning("Não foi possivel carregar a configuracao!");
			e.printStackTrace();
		}		
	}
	
	/**
	 * Resgate do objeto config
	 * @return Retorna um objeto Configuration
	 */
	public Configuration getConfig()
	{		
		return config;
	}
	
	/**
	 * Resgate do objeto ConfigurationOptions para gerenciar as opcoes disponiveis pela configuracao
	 * @return Retorna um objeto ConfigurationOptions
	 */
	public ConfigurationOptions options()
	{
		if(options == null)
			options = new ConfigurationOptions(config,configFile);
		return options;
	}	
	
	/**
	 * Returna um booleano dizendo se é a configuração padrao
	 * @return
	 */
	public boolean isDefault()
	{
		return defaultConfig;
	}
	
	/**
	 * Recuperar a configuração padrão
	 * @return Configuração padrão
	 */
	public static YamlConfiguration getDefaultConfig()
	{
		for (YamlConfiguration yamlConfiguration : configs) 
		{
			if(yamlConfiguration.isDefault())
			{
				return yamlConfiguration;				
			}
		}
		
		YamlConfiguration defaultConfig = new YamlConfiguration("config");
		configs.add(defaultConfig);
		return defaultConfig;
	}
	
	/**
	 * Classe que disponibiliza opções da configuração
	 * @author Lucas
	 *
	 */
	private class ConfigurationOptions
	{
		private Configuration cfg;
		private File fileCfg;
		
		ConfigurationOptions(Configuration config, File fileConfig)
		{
			cfg = config;
			fileCfg = fileConfig;
		}
		
		/**
		 * Utilizado para salvar a configuração no disco
		 */
		@SuppressWarnings("unused")
		public void saveConfig()
		{
			try 
			{
				ConfigurationProvider.getProvider(net.md_5.bungee.config.YamlConfiguration.class).save(cfg, fileCfg);
			} catch (IOException e) 
			{				
				e.printStackTrace();
			}
		}		
	}
}
