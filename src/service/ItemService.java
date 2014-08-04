package service;

import java.util.List;

import mapper.ItemMapper;

import org.springframework.beans.factory.annotation.Autowired;

import vo.Item;

public class ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	public void setItemMapper(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}
	
	public Item getItem() {
		return itemMapper.getItem("EST-1");
	}
	
	public int updateItem(String attr2) {
		return itemMapper.updateItem(attr2);
	}
	
	public List getAdultFemaleItem() {
		return itemMapper.getAdultFemaleItem();
	}
	
	public int deleteItem(String itemId) {
		int count = 0;
		try {
			count = itemMapper.deleteItem(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public int insertItem(Item vo) {
		return itemMapper.insertItem(vo);
	}
	
	public List<Item> selectAllItem() {
		return itemMapper.selectAll();
	}
	
//	public void deleteItem() {
//		itemMapper.deleteItem("");
//	}
}
