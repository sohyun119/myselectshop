package com.sparta.myselectshop.repository;

import com.sparta.myselectshop.dto.ProductResponseDto;
import com.sparta.myselectshop.entity.Product;
import com.sparta.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByUser(User user, Pageable pageable);

    Page<Product> findAllByUserAndProductFolderList_FolderId(User user, Long folderId, Pageable pageable);
    /*
    * select * from product p
    * where p.user_id = 1;
    *
    * select
    *   p.id,
    *   p.title as product_title,
    *   pf.product_id as product_id,
    *   pf.folder_id ad folder_id
    * from
    *   product p left join product_folder pf
    *       on p.id = pf.product_id
    * where
    *   p.user_id = 1
    * and
    *   pf.folder_id = 3
    * order by p.id desc
    * limit 20, 10; // 페이징 처리 <- jpa가 많은 것을 도와주고 있는 걸 알 수 있음
    *
    * //    ㄴ 20은 3번째 페이징을 뜻함
    * */

}
