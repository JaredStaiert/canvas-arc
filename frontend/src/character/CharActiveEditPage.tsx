import React, { JSX, useState } from "react";
import {
  Button,
  Container,
  Fieldset,
  Flex,
  Grid,
  Group,
  Paper,
  Tabs,
  TextInput,
} from "@mantine/core";
import { CharacterDTO } from "@/api/character_api";
import CharacterTextEditor from "@/richText/CharacterTextEditor";

type Mode = "view" | "edit";

interface CharProps {
  character: CharacterDTO;
}

interface ModeStateProps {
  mode: string;
  setMode: React.Dispatch<React.SetStateAction<Mode>>;
}

interface DataStateProps {
  edit: CharacterDTO;
  setEdit: React.Dispatch<React.SetStateAction<CharacterDTO>>;
}

interface BioProps extends CharProps, ModeStateProps, DataStateProps {}

function CharActiveEditPage({ character }: CharProps): JSX.Element {
  const [edit, setEdit] = useState<CharacterDTO>(character);
  const [activeTab, setActiveTab] = useState<string | null>("biography");
  const [mode, setMode] = useState<Mode>("view");
  //TODO: CHECK for any other instances of character state needing to be passed.

  return (
    <>
      <Flex justify="flex-start">
        <Tabs
          radius="xs"
          orientation="vertical"
          defaultValue="gallery"
          value={activeTab}
          onChange={setActiveTab}
          w="75rem"
          h="40rem"
        >
          <Tabs.List>
            <Tabs.Tab value="biography">Biography</Tabs.Tab>
            <Tabs.Tab value="events">Events</Tabs.Tab>
            <Tabs.Tab value="settings">Settings</Tabs.Tab>
          </Tabs.List>

          <Tabs.Panel value="biography">
            <CharToolBar mode={mode} setMode={setMode} />
            <BioSection
              character={character}
              mode={mode}
              setMode={setMode}
              edit={edit}
              setEdit={setEdit}
            />
          </Tabs.Panel>

          <Tabs.Panel value="events">
            <EventSection />
          </Tabs.Panel>

          <Tabs.Panel value="settings">Settings tab content</Tabs.Panel>
        </Tabs>
      </Flex>
    </>
  );
}

/**
 * Toolbar that renders the save button and conditionally edit / stop editing
 * buttons.
 * @param mode Current state.
 * @param setMode Setter function for state.
 */
function CharToolBar({ mode, setMode }: ModeStateProps): JSX.Element {
  function renderButton() {
    switch (mode) {
      case "view":
        return (
          <Button variant="default" onClick={() => setMode("edit")}>
            Edit
          </Button>
        );
      case "edit":
        return (
          <Button variant="default" onClick={() => setMode("view")}>
            Finish
          </Button>
        );
      default:
        return <Button variant="default">Edit</Button>;
    }
  }

  return (
    <>
      <Paper shadow="xs">
        <Container>
          <Group>
            {renderButton()}
            <Button variant="default">Save</Button>
          </Group>
        </Container>
      </Paper>
    </>
  );
}

function BioSection({ character, mode, setMode, edit, setEdit }: BioProps): JSX.Element {
  function bioRenderSwitch(): JSX.Element {
    switch (mode) {
      case "view":
        return <BioSectionView character={character} />;
      case "edit":
        return (
          <BioSectionEdit
            character={character}
            mode={mode}
            setMode={setMode}
            edit={edit}
            setEdit={setEdit}
          />
        );
      default:
        return <>Error</>;
    }
  }

  return (
    <>
      <Grid grow gutter="xl" p="xl">
        {bioRenderSwitch()}
        <Grid.Col span={12}>
          <CharacterTextEditor />
        </Grid.Col>
      </Grid>
    </>
  );
}

function BioSectionView({ character }: CharProps): JSX.Element {
  return (
    <>
      <Grid.Col span={6}>
        <TextInput
          label="Name"
          value={character.characterName}
          style={{ pointerEvents: "none" }}
          readOnly
        />
      </Grid.Col>
      <Grid.Col span={6}>
        <TextInput
          label="Age"
          value={String(character.characterAge)}
          style={{ pointerEvents: "none" }}
          readOnly
        />
      </Grid.Col>
      <Grid.Col span={6}>
        <TextInput
          label="Owner"
          value={character.userName}
          style={{ pointerEvents: "none" }}
          readOnly
        />
      </Grid.Col>
    </>
  );
}

function BioSectionEdit({ character, mode, edit, setEdit }: BioProps): JSX.Element {
  //TODO: ADD handling for setting edit and mutation


    return (
    <>
      <Grid.Col span={6}>
        <Fieldset variant="unstyled" bg={mode === "edit" ? "beige" : ""}>
          <TextInput label="Name" placeholder={character.characterName} />
        </Fieldset>
      </Grid.Col>
      <Grid.Col span={6}>
        <Fieldset variant="unstyled" bg={mode === "edit" ? "beige" : ""}>
          <TextInput label="Age" placeholder={String(character.characterAge)} />
        </Fieldset>
      </Grid.Col>
      <Grid.Col span={6}>
        <Fieldset variant="unstyled" bg={mode === "edit" ? "beige" : ""}>
          <TextInput label="Ownser" placeholder={character.userName} />
        </Fieldset>
      </Grid.Col>
    </>
  );
}

function EventSection() {
  return (
    <>
      <Grid grow gutter="xl" p="xl">
        <EventTimelines/>
      </Grid>
    </>
  );
}

function EventTimelines() {
    return (
        <>
            <p>Timelines</p>
        </>
    );
}

export default CharActiveEditPage;
