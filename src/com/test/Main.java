package com.test;

import java.util.Scanner;

import com.app.Dao.DaoAppartement;
import com.app.Dao.DaoEtage;
import com.app.Dao.DaoFactory;
import com.app.Dao.DaoImmeuble;
import com.app.Dao.DaoRue;
import com.app.Dao.IDao;
import com.app.Dao.TypeDao;
import com.app.models.Appartement;
import com.app.models.Etage;
import com.app.models.Immeuble;
import com.app.models.Rue;

public class Main {

	public static void main(String[] args) {
	   int i= 0;
	   Scanner rs =new Scanner(System.in);
	   while(i != 0) {
		   System.out.println("0- Quitter");
		   System.out.println("1- Afficher Tous Les immeuble");
		   System.out.println("2- Les Immeuble d'un rue");
		   System.out.println("3- Supprimer un appartement par id");
		   System.out.println("4- Modifier un Etage");
		   i = rs.nextInt();
		   switch (i) {
		case 0:
			System.out.println("GoodBye");
			break;
		case 1:
			DaoImmeuble doaImm= (DaoImmeuble) DaoFactory.getDAO(TypeDao.Immeuble);
			for(Immeuble em : doaImm.getAll())
				System.out.println(em);
			break;
		case 2:
			System.out.println("Donner un id de rue");
			int id=rs.nextInt();
			DaoRue doaRue= (DaoRue) DaoFactory.getDAO(TypeDao.Rue);
			Rue rue = doaRue.getOne(id);
			for(Immeuble em : rue.getImmeubles())
				System.out.println(em);
			break;
		case 3:
			System.out.println("Donner un id de Appartement");
			String ids  = rs.next();
			DaoAppartement daoApp= (DaoAppartement) DaoFactory.getDAO(TypeDao.Appartement);
			Appartement app=new Appartement(ids,0);
			if(daoApp.delete(app))
				System.out.println("supprimer avec success");
			else
				System.out.println("can't delete");
			break;
		case 4:
			System.out.println("Donner un id de etage");
			id  = rs.nextInt();
			DaoEtage daoEtage= (DaoEtage) DaoFactory.getDAO(TypeDao.Etage);
			
			System.out.println("Donner un nb App");
			int  nbApp = rs.nextInt();
			Etage et=new Etage(0, nbApp);
			if(daoEtage.update(et))
				System.out.println("mofifier avec success");
			else
				System.out.println("can't update");
			break;

		default:
			break;
		}
	   }
	}

}
