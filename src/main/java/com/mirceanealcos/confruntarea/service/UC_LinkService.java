package com.mirceanealcos.confruntarea.service;

import com.mirceanealcos.confruntarea.entity.UC_Link;
import com.mirceanealcos.confruntarea.repo.UC_LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UC_LinkService {

    @Autowired
    UC_LinkRepository uc_linkRepository;

    public List<UC_Link> getAllLinks() {
        return uc_linkRepository.findAll();
    }

    public List<UC_Link> getLinksByUserId(Long user_id) {
        return uc_linkRepository.findByUserId(user_id);
    }

    public List<UC_Link> getLinksByChampionId(Long champion_id) {
        return uc_linkRepository.findByChampionId(champion_id);
    }

    public void addLink(UC_Link link) throws Exception{
        if(link.getChampion_id() == null) throw new Exception("Champion id not present!");
        if(link.getUser_id() == null) throw new Exception("User id not present!");
        uc_linkRepository.save(link);
    }

    public void updateLink(UC_Link old_link, UC_Link new_link) throws Exception{
        if(new_link.getChampion_id() == null) throw new Exception("New champion id not present!");
        if(new_link.getUser_id() == null) throw new Exception("New user id not present!");
        if(old_link.getUser_id() == null) throw new Exception("Old user id not present!");
        if(old_link.getChampion_id() == null) throw new Exception("Old champion id not present!");
        uc_linkRepository.update(old_link, new_link);
    }

    public int deleteAllLinks() {
        return uc_linkRepository.deleteAll();
    }

    public int deleteLinkByUserId(Long user_id) {
        return uc_linkRepository.deleteByUserId(user_id);
    }

    public int deleteLinkByChampionId(Long champion_id) {
        return uc_linkRepository.deleteByChampionId(champion_id);
    }

}
