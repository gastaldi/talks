package com.lista.app.view;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.query.AuditEntity;

import com.lista.app.Contato;

@Named
@RequestScoped
public class ContatoHistoryBean {


    @PersistenceContext
    private EntityManager entityManager;
    
    private List<ContatoHistoryEntry> list;

    public List<ContatoHistoryEntry> getList() {
        if (list == null) {
            AuditReader auditReader = AuditReaderFactory.get(entityManager);
            @SuppressWarnings({"unchecked"}) List<Object[]> revDatas = (List<Object[]>) auditReader
                    .createQuery()
                    .forRevisionsOfEntity(Contato.class, false, false)
                    .add(AuditEntity.id().eq(id))
                    .getResultList();
            list = new ArrayList<ContatoHistoryEntry>();
            for (Object[] revData : revDatas) {
                list.add(new ContatoHistoryEntry((Contato) revData[0], (DefaultRevisionEntity) revData[1]));
            }
        }
        return list;
   }

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public static class ContatoHistoryEntry {
        private final Contato contato;
        private final String changeDate;

        public ContatoHistoryEntry(Contato contato, DefaultRevisionEntity revision) {
            this.Contato = contato;
            this.changeDate = DateFormat.getTimeInstance().format(revision.getRevisionDate());
   }
 	   public String getChangeDate() {
          return changeDate;
     }

        public Contato getContato() {

            return contato;

      }
	
}

}
