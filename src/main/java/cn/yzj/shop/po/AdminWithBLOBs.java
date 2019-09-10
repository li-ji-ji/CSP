package cn.yzj.shop.po;

public class AdminWithBLOBs extends Admin {
    private String navList;

    private String todolist;

    public String getNavList() {
        return navList;
    }

    public void setNavList(String navList) {
        this.navList = navList == null ? null : navList.trim();
    }

    public String getTodolist() {
        return todolist;
    }

    public void setTodolist(String todolist) {
        this.todolist = todolist == null ? null : todolist.trim();
    }
}