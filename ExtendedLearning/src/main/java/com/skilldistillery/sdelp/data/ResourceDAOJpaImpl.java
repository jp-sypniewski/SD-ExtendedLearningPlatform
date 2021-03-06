package com.skilldistillery.sdelp.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.sdelp.entities.Resource;

@Transactional
@Service
public class ResourceDAOJpaImpl implements ResourceDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Resource addResource(Resource resource) {
		em.persist(resource);
		em.flush();
		return resource;
	}
	
	@Override
	public Resource getResourceById(int id) {
		Resource resource = em.find(Resource.class, id);
		return resource;
	}

	@Override
	public Resource updateResource(Resource resource) {
		Resource managedResource = em.find(Resource.class, resource.getId());
		managedResource.setTitle(resource.getTitle());
		managedResource.setResourceUrl(resource.getResourceUrl());
		managedResource.setActive(resource.getActive());
		em.flush();
		return managedResource;
	}
	
	

}
