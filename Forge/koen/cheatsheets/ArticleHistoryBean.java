package com.inventory.view;

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

import com.inventory.domain.Article;

@Named
@RequestScoped
public class ArticleHistoryBean {


    @PersistenceContext
    private EntityManager entityManager;
    
    private List<ArticleHistoryEntry> list;

    public List<ArticleHistoryEntry> getList() {
        if (list == null) {
            AuditReader auditReader = AuditReaderFactory.get(entityManager);
            @SuppressWarnings({"unchecked"}) List<Object[]> revDatas = (List<Object[]>) auditReader
                    .createQuery()
                    .forRevisionsOfEntity(Article.class, false, false)
                    .add(AuditEntity.id().eq(id))
                    .getResultList();
            list = new ArrayList<ArticleHistoryEntry>();
            for (Object[] revData : revDatas) {
                list.add(new ArticleHistoryEntry((Article) revData[0], (DefaultRevisionEntity) revData[1]));
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
    public static class ArticleHistoryEntry {
        private final Article article;
        private final String changeDate;

        public ArticleHistoryEntry(Article article, DefaultRevisionEntity revision) {
            this.article = article;
            this.changeDate = DateFormat.getTimeInstance().format(revision.getRevisionDate());
   }
 	   public String getChangeDate() {
          return changeDate;
     }

        public Article getArticle() {

            return article;

      }
	
}

}
