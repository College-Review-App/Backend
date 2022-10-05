// Material UI
import {
  FormControlLabel,
  Modal,
  Radio,
  RadioGroup,
  Autocomplete,
  TextField,
  Switch,
} from "@mui/material";
import CloseIcon from "@mui/icons-material/Close";
import AddIcon from "@mui/icons-material/Add";
import RemoveIcon from "@mui/icons-material/Remove";
import { SetStateAction, useEffect, useState } from "react";
// Add review component CSS
import './AddReviewModal.css';
import PlacesAutocomplete from 'react-places-autocomplete';
import { config } from "../../constants";
import TagManager from 'react-gtm-module';

// Represents the Form to add a profile / review to a college
const AddReviewModal = ({
  refresh,
  open,
  collegeName,
  callback
}: {
  refresh: boolean;
  open: boolean;
  collegeName: string;
  callback: Function
}) => {
  let ethnicityOptions: string[] = [
    'American Indian or Alaskan Native',
    'Asian',
    'Hispanic/Latino',
    'Black or African American',
    'White',
    'Native Hawaiian or Other Pacific Islander',
    'Two or More Races',
  ];
  let classOptions: string[] = [
    '2026',
    '2025',
    '2024',
    '2023',
    '2022',
    '2021',
    '2020',
    '2019',
    '2018',
    '2017',
    '2016',
    '2015',
    '2014',
  ];

  const [modalOpen, setModalOpen] = useState<boolean>(false);
  const handleClose = () => {
    setModalOpen(false);
    setInvalidLocation(false);
    setInvalidClass(false);
    setInvalidEthnicity(false);
    setInvalidMajor(false);
    setInvalidGPA(false);
    setInvalidOutcome(false);
    setInvalidSAT(false);
    setInvalidACT(false);
    setTookSAT(true);
    setTookACT(true);
    setInvalidGender(false);
    setInvalidIncome(false);
    setInvalidExtracurriculars(false);
    setInvalidAdvice(false);
    setInvalidMajor(false);

    setGender(undefined);
    setFamilyIncome(undefined);
    setOutcome(undefined);
    setIntendedMajor('');
    setEthnicity(undefined);
    setClassOf(undefined);
    setFirstGenStudent(false);
    setLegacyStudent(false);
    setGPA(undefined);
    setLocation('');
    setLocationText('');
    setExtracurricularArray(['']);
    setAdvice('');
    setCanSubmit(true);
  };

  const tagManagerArgs = {
    gtmId: 'GTM-MC6CHCK',
    events: {
      name: 'College Application Submitted'
    }
  }

  useEffect(() => {
    setModalOpen(open);
  }, [refresh]);

  // Boolean that enables the user to submit the modal, should be false right
  // after a request is made and being processed.
  const [canSubmit, setCanSubmit] = useState<boolean>(true);

  // state fields for user input form asked to an applicant
  const [location, setLocation] = useState<string>('');
  // This extra location text is for making sure the user can't
  // input their own locations without using the picker
  const [locationText, setLocationText] = useState<string>('');
  const [classOf, setClassOf] = useState<number>();
  const [firstGenStudent, setFirstGenStudent] = useState<boolean>(false);
  const [legacyStudent, setLegacyStudent] = useState<boolean>(false);
  const [ethnicity, setEthnicity] = useState<string>();
  const [gender, setGender] = useState<number>();
  const [familyIncome, setFamilyIncome] = useState<number>();
  const [GPA, setGPA] = useState<number>();
  const [SAT, setSAT] = useState<number>();
  const [tookSAT, setTookSAT] = useState<boolean>(true);
  const [ACT, setACT] = useState<number>();
  const [tookACT, setTookACT] = useState<boolean>(true);
  const [intendedMajor, setIntendedMajor] = useState<string>('');
  const [extracurricularArray, setExtracurricularArray] = useState<string[]>([
    '',
  ]);
  const [advice, setAdvice] = useState<string>('');
  const [outcome, setOutcome] = useState<number>();

  // invalid states for user inputs
  const [invalidLocation, setInvalidLocation] = useState<boolean>(false);
  const [invalidClass, setInvalidClass] = useState<boolean>(false);
  const [invalidEthnicity, setInvalidEthnicity] = useState<boolean>(false);
  const [invalidGPA, setInvalidGPA] = useState<boolean>(false);
  const [invalidSAT, setInvalidSAT] = useState<boolean>(false);
  const [invalidACT, setInvalidACT] = useState<boolean>(false);
  const [invalidMajor, setInvalidMajor] = useState<boolean>(false);
  const [invalidOutcome, setInvalidOutcome] = useState<boolean>(false);
  const [invalidGender, setInvalidGender] = useState<boolean>(false);
  const [invalidIncome, setInvalidIncome] = useState<boolean>(false);
  const [invalidExtracurriculars, setInvalidExtracurriculars] =
    useState<boolean>(false);
  const [invalidAdvice, setInvalidAdvice] = useState<boolean>(false);

  const [addProfileSubmissionError, setAddProfileSubmissionError] =
    useState<boolean>(false);

  const handleAddExtracurricular = () => {
    if (extracurricularArray.length < 5) {
      setExtracurricularArray([...extracurricularArray, '']);
    }
  };

  const handleDeleteExtracurricular = () => {
    if (extracurricularArray.length > 1) {
      let newArr = extracurricularArray.slice(
        0,
        extracurricularArray.length - 1
      );
      setExtracurricularArray(newArr);
    }
  };

  const handleLocationSelect = async (value: SetStateAction<string>) => {
    setInvalidLocation(false);
    setLocation(value);
    setLocationText(value);
  };

  // checks certain user input field requiremnts
  const handleSubmit = () => {
    let validSubmission = true;
    if (location === '' || location == null || location == undefined) {
      setInvalidLocation(true);
      validSubmission = false;
    }
    if (classOf == null || classOf == undefined) {
      setInvalidClass(true);
      validSubmission = false;
    }
    if (ethnicity == null || ethnicity == undefined) {
      setInvalidEthnicity(true);
      validSubmission = false;
    }
    if (!GPA || GPA > 4.0 || GPA < 0.0) {
      setInvalidGPA(true);
      validSubmission = false;
    }
    if (outcome == null || outcome == undefined) {
      setInvalidOutcome(true);
      validSubmission = false;
    }
    if (gender == null || gender == undefined) {
      setInvalidGender(true);
      validSubmission = false;
    }
    if (familyIncome == null || familyIncome == undefined) {
      setInvalidIncome(true);
      validSubmission = false;
    }
    if (
      intendedMajor === '' ||
      intendedMajor == undefined ||
      intendedMajor == null || intendedMajor.length > 40
    ) {
      setInvalidMajor(true);
      validSubmission = false;
    }
    if (tookSAT) {
      if (SAT == undefined || SAT < 400 || SAT > 1600 || SAT % 10 != 0) {
        setInvalidSAT(true);
        validSubmission = false;
      }
    }
    if (tookACT) {
      if (ACT == undefined || ACT < 1 || ACT > 36) {
        setInvalidACT(true);
        validSubmission = false;
      }
    }
    if (
      advice == null ||
      advice == undefined ||
      advice.length < 50 ||
      advice.length > 2000
    ) {
      setInvalidAdvice(true);
      validSubmission = false;
    }
    if (!extracurricularsValid()) {
      setInvalidExtracurriculars(true);
      validSubmission = false;
    }
    if (validSubmission) {
      submitProfileForm();
    }
  };

  const submitProfileForm = () => {
    setCanSubmit(false);
    let locationArr = location.split(',');
    locationArr.forEach((text, index) => {
      locationArr[index] = text.trim();
    });
    let city: string = '';
    let state: string = '';
    let country: string = '';
    if (locationArr.length === 3) {
      city = locationArr[0];
      state = locationArr[1];
      country = locationArr[2];
    } else {
      city = locationArr[0];
      country = locationArr[1];
    }
    let extracurricularsText: string = '';
    extracurricularArray.forEach((ec) => {
      if (ec != "") {
        extracurricularsText += ec.trim() + "|+=+|"
      }
    });
    extracurricularsText = extracurricularsText.substring(
      0,
      extracurricularsText.length - 5
    );
    addApplicationToDatabase(city, state, country, extracurricularsText);
  };

  const extracurricularsValid = () => {
    const numExtracurriculars = extracurricularArray.length;
    let emptyExtracurriculars = 0;
    let valid = true;
    extracurricularArray.forEach((ec) => {
      if (ec.length > 200) {
        console.log(ec.length);
        valid = false;
      }
      if (ec === '') {
        emptyExtracurriculars++;
      }
    });
    if (numExtracurriculars == emptyExtracurriculars) {
      valid = false;
    }
    return valid;
  };

  const addApplicationToDatabase = (
    city: string,
    state: string,
    country: string,
    extracurriculars: string
  ) => {
    const requestOptions = {
      method: 'POST',
      body: JSON.stringify({
        city: city,
        state: state,
        country: country,
        ethnicity: ethnicity,
        classOf: classOf,
        firstGen: firstGenStudent,
        legacyStudent: legacyStudent,
        gender: gender,
        familyIncome: familyIncome,
        GPA: GPA,
        SAT: tookSAT ? SAT : -1,
        ACT: tookACT ? ACT : -1,
        intendedMajor: intendedMajor,
        extracurriculars: extracurriculars,
        advice: advice,
        outcome: outcome,
      }),
    };
    fetch(
      `${config.url.API_URL}/add-application-by-college-name?collegeName=${collegeName}`,
      requestOptions
    )
      .then(async (response) => {
        const data = await response.json();
        callback();
        handleClose();
        setModalOpen(false);
        if (config.analytics) {
          TagManager.initialize(tagManagerArgs);
        }
      })
      .catch((error) => {
        console.log('There was an error!', error);
        setAddProfileSubmissionError(true);
      });
    setCanSubmit(true);
  };

  return (
    <Modal open={modalOpen} onClose={handleClose}>
      <div className="addReviewModalContainer">
        <div className="addReviewModalHeaderContainer">
          <CloseIcon
            style={{ cursor: 'pointer' }}
            onClick={() => handleClose()}
            fontSize="medium"
          />
        </div>
        <form>
          <div className="addReviewModalDisclaimerContainer">
            <p>Note - All profiles are 100% anonymous 😎</p>
          </div>
          <div className="addReviewUserFormContainer">
            <label>
              Class of*
              <Autocomplete
                options={classOptions}
                size="small"
                onChange={(e) => {
                  const element = e.target as HTMLInputElement;
                  const value = element.innerHTML;
                  setClassOf(parseInt(value));
                  setInvalidClass(false);
                }}
                renderInput={(params) => (
                  <TextField {...params} label="Select" />
                )}
              />
              {invalidClass && (
                <p className="addReviewModalInvalidInputWarning">
                  Class of is required
                </p>
              )}
            </label>
            <label>
              Intended Major*
              <input
                className="addReviewModalTextInput"
                type="text"
                name="Intended Major"
                value={intendedMajor}
                onChange={(text) => {
                  setIntendedMajor(text.target.value);
                  setInvalidMajor(false);
                }}
              />
              {invalidMajor && (
                <p className="addReviewModalInvalidInputWarning">
                  Intended major is required and must be less than 40 characters
                </p>
              )}
            </label>
            <label>
              GPA*
              <input
                className="addReviewModalTextInput"
                onWheelCapture={(e) => {
                  e.currentTarget.blur();
                }}
                type="number"
                name="GPA"
                onChange={(number) => {
                  setGPA(parseFloat(number.target.value));
                  setInvalidGPA(false);
                }}
              />
              {invalidGPA && (
                <p className="addReviewModalInvalidInputWarning">
                  Invalid GPA (4.0 Scale)
                </p>
              )}
            </label>
            <label>
              SAT*
              <input
                className="addReviewModalTextInput"
                onWheelCapture={(e) => {
                  e.currentTarget.blur();
                }}
                type="number"
                name="SAT"
                disabled={!tookSAT}
                onChange={(number) => {
                  setSAT(parseInt(number.target.value));
                  setInvalidSAT(false);
                }}
              />
              <FormControlLabel
                control={<Switch />}
                onChange={() => {
                  setTookSAT(!tookSAT);
                  setInvalidSAT(false);
                }}
                label="Did not take the SAT"
              />
              {invalidSAT && (
                <p className="addReviewModalInvalidInputWarning">
                  Invalid SAT Entry
                </p>
              )}
            </label>
            <label>
              ACT*
              <input
                className="addReviewModalTextInput"
                onWheelCapture={(e) => {
                  e.currentTarget.blur();
                }}
                type="number"
                name="ACT"
                disabled={!tookACT}
                onChange={(number) => {
                  setACT(parseInt(number.target.value));
                  setInvalidACT(false);
                }}
              />
              <FormControlLabel
                control={<Switch />}
                onChange={() => {
                  setTookACT(!tookACT);
                  setInvalidACT(false);
                }}
                label="Did not take the ACT"
              />
              {invalidACT && (
                <p className="addReviewModalInvalidInputWarning">
                  Invalid ACT Entry
                </p>
              )}
            </label>
            <label>
              Location*
              <PlacesAutocomplete
                value={locationText}
                onChange={setLocationText}
                onSelect={handleLocationSelect}
                searchOptions={{ types: ['(cities)'] }}
              >
                {({
                  getInputProps,
                  suggestions,
                  getSuggestionItemProps,
                  loading,
                }) => (
                  <div>
                    <input
                      {...getInputProps({
                        className: 'addReviewModalLocationPicker',
                      })}
                    />
                    <div>
                      {suggestions.map((suggestion) => {
                        const style = {
                          fontWeight: suggestion.active ? 'bold' : '400',
                          cursor: 'pointer',
                          fontSize: suggestion.active ? 13.5 : 13,
                          marginBottom: 15,
                          marginLeft: 5.5,
                        };
                        return (
                          <div
                            {...getSuggestionItemProps(suggestion, { style })}
                            key={suggestion.id}
                          >
                            {suggestion.description}
                          </div>
                        );
                      })}
                    </div>
                  </div>
                )}
              </PlacesAutocomplete>
              {invalidLocation && (
                <p
                  style={{ marginTop: '-10px' }}
                  className="addReviewModalInvalidInputWarning"
                >
                  Location is required and must be selected from dropdown.
                </p>
              )}
            </label>
            <label>
              Gender*
              <RadioGroup
                row
                aria-labelledby="gender-radio-buttons-group"
                name="genderRadioButtons"
                onChange={() => setInvalidGender(false)}
              >
                <FormControlLabel
                  value="Male"
                  control={<Radio />}
                  label="Male"
                  onChange={() => setGender(0)}
                />
                <FormControlLabel
                  value="Female"
                  control={<Radio />}
                  label="Female"
                  onChange={() => setGender(1)}
                />
                <FormControlLabel
                  value="Other"
                  control={<Radio />}
                  label="Other"
                  onChange={() => setGender(2)}
                />
              </RadioGroup>
              {invalidGender && (
                <p className="addReviewModalInvalidInputWarning">
                  Gender is required
                </p>
              )}
            </label>
            <label>
              Ethnicity*
              <Autocomplete
                options={ethnicityOptions}
                size="small"
                onChange={(e) => {
                  const element = e.target as HTMLInputElement;
                  const value = element.innerHTML;
                  setEthnicity(value);
                  setInvalidEthnicity(false);
                }}
                renderInput={(params) => (
                  <TextField {...params} label="Select" />
                )}
              />
              {invalidEthnicity && (
                <p className="addReviewModalInvalidInputWarning">
                  Ethnicity is required
                </p>
              )}
            </label>

            <label>
              Family Income*
              <RadioGroup
                row
                aria-labelledby="income-radio-buttons-group"
                name="incomeRadioButtons"
                onChange={() => setInvalidIncome(false)}
              >
                <FormControlLabel
                  value="0k - 25k"
                  control={<Radio />}
                  label="0k - 25k"
                  onChange={() => setFamilyIncome(25000)}
                />
                <FormControlLabel
                  value="25k - 50k"
                  control={<Radio />}
                  label="25k - 50k"
                  onChange={() => setFamilyIncome(50000)}
                />
                <FormControlLabel
                  value="50k - 100k"
                  control={<Radio />}
                  label="50k - 100k"
                  onChange={() => setFamilyIncome(100000)}
                />
                <FormControlLabel
                  value="100k-250k"
                  control={<Radio />}
                  label="100k-250k"
                  onChange={() => setFamilyIncome(250000)}
                />
                <FormControlLabel
                  value="250k+"
                  control={<Radio />}
                  label="250k+"
                  onChange={() => setFamilyIncome(1000000)}
                />
              </RadioGroup>
              {invalidIncome && (
                <p className="addReviewModalInvalidInputWarning">
                  Income is required
                </p>
              )}
            </label>
            <label>
              <FormControlLabel
                control={<Switch />}
                checked={firstGenStudent}
                onChange={() => {
                  if (!firstGenStudent) {
                    if (legacyStudent) {
                      setLegacyStudent(false)
                    }
                  }
                  setFirstGenStudent(!firstGenStudent);
                }}
                label=""
              />
              I am a first generation student
            </label>
            <label>
              <FormControlLabel
                control={<Switch />}
                checked={legacyStudent}
                onChange={() => {
                  if (!legacyStudent) {
                    if (firstGenStudent) {
                      setFirstGenStudent(false)
                    }
                  }
                  setLegacyStudent(!legacyStudent);
                }}
                label=""
              />
              I am a legacy student 
            </label>
            <label>
              <div className="addReviewModalExtracurricularsHeaderContainer">
                <p>Extracurriculars*</p>
                <div className="addReviewModalAddExtracurricularsContainer">
                  <p style={{ marginRight: '20px' }}>5 Extracurriculars Max</p>
                  <AddIcon
                    style={{ cursor: 'pointer' }}
                    onClick={() => {
                      handleAddExtracurricular();
                      setInvalidExtracurriculars(false);
                    }}
                  />
                  <RemoveIcon
                    style={{ cursor: 'pointer' }}
                    onClick={() => {
                      handleDeleteExtracurricular();
                      setInvalidExtracurriculars(false);
                    }}
                  />
                </div>
              </div>
              {extracurricularArray.map((ec: string, index: number) => (
                <input
                  key={index}
                  className="addReviewModalTextInput"
                  name="Extracurriculars"
                  onChange={(text) => {
                    let newArr = [...extracurricularArray];
                    newArr[index] = text.target.value;
                    setExtracurricularArray(newArr);
                    setInvalidExtracurriculars(false);
                  }}
                />
              ))}
              {invalidExtracurriculars && (
                <p className="addReviewModalInvalidInputWarning">
                  At least one extracurricular is required, and extracurriculars
                  must be less than 200 characters
                </p>
              )}
            </label>
            <label>
              Advice*
              <textarea
                className="addReviewModalTextArea"
                name="Advice"
                value={advice}
                onChange={(text) => {
                  setAdvice(text.target.value);
                  setInvalidAdvice(false);
                }}
              />
              {invalidAdvice && (
                <p className="addReviewModalInvalidInputWarning">
                  Advice is required and must be between 50 and 2000 characters
                </p>
              )}
            </label>
            <label>
              Outcome*
              <RadioGroup
                row
                aria-labelledby="outcome-radio-buttons-group"
                name="outcomeRadioButtons"
                onChange={() => setInvalidOutcome(false)}
              >
                <FormControlLabel
                  value="Accepted"
                  control={<Radio />}
                  label="Accepted"
                  onChange={() => {
                    setOutcome(1);
                  }}
                />
                <FormControlLabel
                  value="Denied"
                  control={<Radio />}
                  label="Denied"
                  onChange={() => {
                    setOutcome(0);
                  }}
                />
              </RadioGroup>
              {invalidOutcome && (
                <p className="addReviewModalInvalidInputWarning">
                  Outcome is required
                </p>
              )}
            </label>
          </div>
        </form>
        <button
          className="addReviewModalSubmitButton"
          onClick={() => (canSubmit ? handleSubmit() : null)}
        >
          Submit
        </button>
        {addProfileSubmissionError && (
          <p className="addReviewModalInvalidInputWarning">
            Sorry, something went wrong with your submission
          </p>
        )}
      </div>
    </Modal>
  );
};

export default AddReviewModal;
