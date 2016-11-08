package sk.cyklosoft.cykloservice.mobile;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import sk.cyklosoft.cykloservice.data.CykloResponseData;
import sk.cyklosoft.cykloservice.vo.CykloVO;
import sk.cyklosoft.cykloservice.vo.HrmVO;
import sk.cyklosoft.cykloservice.vo.SportActivityList;

@RequestMapping("/sport")
public interface UserSport {
	
//start training	
	/*@RequestMapping(value = "/{username}/{sport_type}", method = RequestMethod.POST)
    public @ResponseBody void startTraining(@PathVariable String username, @PathVariable SportType sportType);
	*/
//stop training	
	/*@RequestMapping(value = "/{username}/{sport_type}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void stopTraining(@PathVariable String username, @PathVariable SportType sportType);
	*/
//set training data
	@RequestMapping(value = "/cyklodata/{username}", method = RequestMethod.POST)
	public @ResponseBody void setTrainingDataHRM(@PathVariable("username") String username,@RequestBody CykloVO cyklo);
	
//last, current	real time reading
	@RequestMapping(value = "/cyklodata/{username}/{sport_type}", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<CykloResponseData>  getTrainingData(@PathVariable("username") String username, @PathVariable("sport_type") String sportType);
	
//individual ladder	
	@RequestMapping(value = "/cyklodatastat/{username}/{sport_type}/{dateFrom}/{dateTo}/{orderBy}", method = RequestMethod.GET)
    public @ResponseBody SportActivityList getTrainingStatisticList(@PathVariable("username") String username, @PathVariable("sport_type") String sportType, 
    		@PathVariable("dateFrom") String dateFrom, @PathVariable("dateTo") String dateTo, @PathVariable("orderBy") String orderBy);
	
//delete all training data
		@RequestMapping(value = "/deletecyklodata/{username}/{sport_type}", method = RequestMethod.DELETE)
		public @ResponseBody void deleteTrainingDataHRM(@PathVariable("username") String username,@PathVariable("sport_type") String sportType);
		
//delete all training data by date
		@RequestMapping(value = "/deletecyklodata/{username}/{sport_type}/{date}", method = RequestMethod.DELETE)
		public @ResponseBody void deleteTrainingDataHRMByDate(@PathVariable("username") String username,@PathVariable("sport_type") String sportType
				,@PathVariable("date") String date);
		
	
	
}
