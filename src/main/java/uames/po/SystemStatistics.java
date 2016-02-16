package uames.po;

/**
 * 系统统计表
 * @author Cindy
 *
 */
public class SystemStatistics  extends Base {
    private Double total_financing;     // 历史总融到的资金
    private Double total_interest;      // 用户总利益
    private Long total_transaction;   // 总交易人数
    public Double getTotal_financing() {
        return total_financing;
    }
    public void setTotal_financing(Double total_financing) {
        this.total_financing = total_financing;
    }
    public Double getTotal_interest() {
        return total_interest;
    }
    public void setTotal_interest(Double total_interest) {
        this.total_interest = total_interest;
    }
    public Long getTotal_transaction() {
        return total_transaction;
    }
    public void setTotal_transaction(Long total_transaction) {
        this.total_transaction = total_transaction;
    }


    /**
     * CREATE TABLE `system_statistics` ( `id` bigint(20) NOT NULL
     * AUTO_INCREMENT, `total_financing` DECIMAL DEFAULT 0.00 , `status` int(11)
     * DEFAULT 0, `sort` int(11) DEFAULT NULL, `description` varchar(300)
     * DEFAULT NULL, `add_time` bigint(20) DEFAULT NULL, `update_time`
     * bigint(20) DEFAULT NULL, PRIMARY KEY (`id`) ) ENGINE=InnoDB
     * AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
     */
}
