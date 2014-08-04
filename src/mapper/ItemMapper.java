package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import vo.Item;

public interface ItemMapper {
	@Select("SELECT * FROM item WHERE itemid = #{itemId}")
	@ResultMap("itemResult")
	Item getItem(@Param("itemId") String itemId);
	
	String MQL_CREATE_ITEM = "INSERT INTO item (ITEMID, PRODUCTID, SUPPLIER, ATTR1, ATTR2, STATUS) values (#{itemId}, #{productId}, #{supplier}, #{attr1}, #{attr2}, #{status})";
	@Insert(MQL_CREATE_ITEM)
	int insertItem(Item vo);

	@Delete("DELETE item WHERE itemid = #{itemId}")
	int deleteItem(@Param("itemId") String itemId);

	@Update("UPDATE item SET ATTR2=#{attr2} WHERE ATTR1 = 'Adult Female'")
	int updateItem(@Param("attr2") String attr2);
	
	@Select("SELECT * FROM item WHERE ATTR1 = 'Adult Female'")
	@ResultMap("itemResult")
	List<Item> getAdultFemaleItem();
	
	List<Item> selectAll();
}
