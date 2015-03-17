package models.daos.jpa;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.daos.TemaDao;
import models.daos.VotoDao;
import models.entities.TemaEntity;
import models.entities.VotoEntity;
import models.utils.Studies;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VotoDaoJpaTest {

	private VotoDao votoDao = DaoJpaFactory.getFactory().getVotoDao();
	private TemaDao temaDao = DaoJpaFactory.getFactory().getTemaDao();
	
	private ArrayList<VotoEntity> data;

	@Before
	public void init() {
		data = new ArrayList<VotoEntity>();
		TemaEntity tema1 = new TemaEntity("Tema 1", "Pregunta 1");
		TemaEntity tema2 = new TemaEntity("Tema 2", "Pregunta 2");
		TemaEntity tema3 = new TemaEntity("Tema 3", "Pregunta 3");
		temaDao.create(tema1);
		temaDao.create(tema2);
		temaDao.create(tema3);
		data.add(new VotoEntity("IP1", 3.5, Studies.ESO, tema1));
		data.add(new VotoEntity("IP2", 5.0, Studies.MASTER, tema2));
		data.add(new VotoEntity("IP3", 4.2, Studies.UNIVERSITARIOS, tema3));
	}
	
	@BeforeClass
	public static void beforeClass() {
		DaoJpaFactory.setFactory(new DaoJpaFactory());
		DaoJpaFactory.dropAndCreateTables();
	}
	
	@Test
	public void testCreate() {
		for (VotoEntity voto: data) {
			votoDao.create(voto);
		}
		List<VotoEntity> votos = votoDao.findAll();
		for (VotoEntity voto : data) {
			assertTrue(votos.contains(voto));
		}

	}

	@Test
	public void testRead() {
		for (VotoEntity voto: data) {
			votoDao.create(voto);
		}
		List<VotoEntity> votos = votoDao.findAll();
		for (int i = 0; i < votos.size(); i++) {
			VotoEntity voto = votoDao.read(votos.get(i).getId());
			VotoEntity comp = data.get(i);
			assertTrue(voto.equals(comp));
		}
	}

	@Test
	public void testUpdate() {
		for (VotoEntity voto: data) {
			votoDao.create(voto);
		}
		String ip = "IP ACT";
		Double voto = 2.8;
		TemaEntity tema = new TemaEntity("Tema nuevo", "Pregunta nueva");
		temaDao.create(tema);
		List<VotoEntity> votos = votoDao.findAll();
		votos.get(0).setIpUser(ip);
		votos.get(0).setVote(voto);
		votos.get(0).setStudies(Studies.GSUPERIOR);
		votos.get(0).setTema(tema);
		VotoEntity updated = new VotoEntity(ip, voto, Studies.GSUPERIOR, tema);
		votoDao.update(votos.get(0));
		votos = votoDao.findAll();
		assertEquals(updated, votos.get(0));
	}

	@Test
	public void testDeleteById() {
		for (VotoEntity voto: data) {
			votoDao.create(voto);
		}
		List<VotoEntity> votos = votoDao.findAll();
		for (int i = 0; i < votos.size(); i++) {
			votoDao.deleteById(votos.get(i).getId());
			VotoEntity deleted = votoDao.read(votos.get(i).getId());
			assertNull(deleted);
		}
	}

	@After
	public void after() {
		List<VotoEntity> votos = votoDao.findAll();
		for (int i = 0; i < votos.size(); i++) {
			votoDao.deleteById(votos.get(i).getId());
		}
	}
}
