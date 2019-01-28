package com.ingartek.here.helper;

import java.io.File;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class ResourceFileLoader {

	/**
	 * Obtiene un fichero desde el directorio resources
	 * @param pFilePath
	 * @return
	 */
	public Optional<File> getFileFromResources(String pFilePath) {
		try {
			ClassLoader classLoader = getClass().getClassLoader();
			return Optional.ofNullable(
					new File(
							classLoader
							.getResource(pFilePath)
							.getFile()));
		}catch(NullPointerException e) {
			return Optional.empty();
		}
	}
	
	/**
	 * Obtiene un fichero de cualquier directorio.
	 * @param pFilePath
	 * @return
	 */
	public Optional<File> getFileFromPath(String pFilePath){
		try {
			return Optional.ofNullable(
					new File(pFilePath));
		}catch(NullPointerException e) {
			return Optional.empty();
		}
	}
	
}