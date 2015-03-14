package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.TemaDao;
import models.entities.TemaEntity;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TemaDaoJpaTest {
	
	private TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
	
	private ArrayList<TemaEntity> data;

	@Before
	public void init() {
		data = new ArrayList<TemaEntity>();
		data.add(new TemaEntity("Tema 1", "Pregunta 1"));
		data.add(new TemaEntity("Tema 2", "Pregunta 2"));
		data.add(new TemaEntity("Tema 3", "Pregunta 3"));
	}
	
	@BeforeClass
	public static void prepare() {
		DaoJpaFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}
	
	@Test
	public void testCreate() {
		for (TemaEntity tema: data) {
			temaDao.create(tema);
		}
		List<TemaEntity> temas = temaDao.findAll();
		for (TemaEntity tema : data) {
			assertTrue(temas.contains(tema));
		}
		assertTrue(temas.size() == data.size());		
	}

	@Test
	public void testRead() {
		for (TemaEntity tema: data) {
			temaDao.create(tema);
		}
		for (int i = 1; i < data.size()-1; i++) {
			temaDao.read(i);
			
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteById() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindAll() {
		fail("Not yet implemented");
	}

}
